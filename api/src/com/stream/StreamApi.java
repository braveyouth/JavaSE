package com.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author zhangy
 * @Time 2021-03-04 10:12
 * @Description: Stream流
 */
public class StreamApi {
    public static void main(String[] args) {
        //1.创建Stream

        //1.1 静态工厂方法
        //1.1.1 of:其生成的Stream是有限长度的，Stream的长度为其内的元素个数。
        //of(T... values)：返回含有多个T元素的Stream
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        integerStream.forEach(System.out::println);
        System.out.println("------------------------------of(T... values)------------------------------");
        //of(T t)：返回含有一个T元素的Stream
        Stream<String> helloStream = Stream.of("hello");
        System.out.println(helloStream.count());
        System.out.println("------------------------------of(T t)------------------------------");
        //1.1.2 generator:返回一个无限长度的Stream,其元素由Supplier接口的提供。
        //generate(Supplier<T> s)：返回一个无限长度的Stream
        //通常用于随机数、常量的 Stream，或者需要前后元素间维持着某种状态信息的 Stream
        //把将Supplier 实例传递给 Stream.generate() 生成的 Stream，默认是串行（相对 parallel 而言）但无序的（相对 ordered 而言）
        //一般无限长度的Stream会与filter、limit等配合使用，否则Stream会无限制的执行下去
        Stream<Object> generate = Stream.generate(new Supplier<Object>() {
            @Override
            public Object get() {
                return Math.random();
            }
        });
        generate.limit(1).forEach(System.out::println);
        Stream.generate(() -> Math.random()).limit(1).forEach(System.out::println);
        Stream.generate(Math::random).limit(1).forEach(System.out::println);
        System.out.println("------------------------------generate(Supplier<T> s)------------------------------");
        //1.1.3 iterate:其返回的也是一个无限长度的Stream
        //iterate(T seed, UnaryOperator<T> f)
        // 与generate方法不同的是，其是通过函数f迭代对给指定的元素种子而产生无限连续有序Stream，其中包含的元素可以认为是：seed，f(seed),f(f(seed))无限循环。
        Stream.iterate(1,integer -> integer+1).limit(5).forEach(System.out::println);
        System.out.println("------------------------------iterate(T seed, UnaryOperator<T> f)------------------------------");
        //1.1.4 empty:返回一个空的顺序Stream，该Stream里面不包含元素项
        //empty()
        Stream.empty().forEach(System.out::println);
        System.out.println("------------------------------empty()------------------------------");

        //1.2 Collection接口和数组的默认方法
        //在Collection接口中，定义了一个默认方法stream()，用来生成一个Stream
        Arrays.asList(1,2).stream().forEach(System.out::println);
        System.out.println("------------------------------Collection接口------------------------------");
        //在Arrays类，封装了一些列的Stream方法，不仅针对于任何类型的元素采用了泛型，更对于基本类型作了相应的封装，以便提升Stream的处理效率。
        Arrays.stream(new String[]{"A","B"}).forEach(System.out::println);
        System.out.println("------------------------------Arrays类------------------------------");

        //1.3 其他：Random.ints()，BitSet.stream()，Pattern.splitAsStream(java.lang.CharSequence)，JarFile.stream()

        //2.Intermediate:主要是用来对Stream做出相应转换及限制流，实际上是将源Stream转换为一个新的Stream，以达到需求效果
        //2.1 concat(Stream<? extends T> a, Stream<? extends T> b):
        //将两个Stream连接在一起，合成一个Stream。若两个输入的Stream都是排序的，则新Stream也是排序的；若输入的Stream中任何一个是并行的，则新的Stream也是并行的；
        // 若关闭新的Stream时，原两个输入的Stream都将执行关闭处理。
        Stream.concat(Stream.of(1,2,3),Stream.of(4,5))
                .forEach(integer -> System.out.println(integer));
        System.out.println("------------------------------concat(Stream<? extends T> a, Stream<? extends T> b)------------------------------");
        //2.2 distinct():
        //达到去除掉原Stream中重复的元素，生成的新Stream中没有没有重复的元素。
        Stream.of(1,2,3,4,5,1,3,5)
                .distinct()
                .forEach(System.out::println);
        System.out.println("------------------------------distinct()------------------------------");
        // 2.3 filter(Predicate<? super T> predicate):
        //对原Stream按照指定条件过滤，在新建的Stream中，只包含满足条件的元素，将不满足条件的元素过滤掉。
        Stream.of(1,2,3,4,5)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer>3;
                    }
                })
//                .filter(integer -> integer > 3)
                .forEach(System.out::println);
        System.out.println("------------------------------filter(Predicate<? super T> predicate)------------------------------");
        //2.4 map(Function<? super T, ? extends R> mapper)
        //将对于Stream中包含的元素使用给定的转换函数进行转换操作，新生成的Stream只包含转换生成的元素。
        Stream.of("a","b","hello")
                .map(new Function<String, Object>() {
                    @Override
                    public Object apply(String s) {
                        return s.toUpperCase();
                    }
                })
//                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
        System.out.println("------------------------------map(Function<? super T, ? extends R> mapper)------------------------------");
        //2.5 flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        //与map方法类似，都是将原Stream中的每一个元素通过转换函数转换,不同的是，该换转函数的对象是一个Stream，也不会再创建一个新的Stream,而是将原Stream的元素取代为转换的Stream
        //如果转换函数生产的Stream为null，应由空Stream取代。flatMap有三个对于原始类型的变种方法，分别是：flatMapToInt，flatMapToLong和flatMapToDouble
        Stream.of(1,2,3)
                .flatMap(new Function<Integer, Stream<?>>() {
                    @Override
                    public Stream<?> apply(Integer integer) {
                        return Stream.of(integer * 10);
                    }
                })
//                .flatMap(integer -> Stream.of(integer * 10))
                .forEach(System.out::println);
        System.out.println("------------------------------flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)------------------------------");
        //2.6 peek(Consumer<? super T> action)
        //peek方法生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），新Stream每个元素被消费的时候都会执行给定的消费函数，并且消费函数优先执行
        Stream.of(1,2,3,4,5)
//                .peek(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) {
//                        System.out.println("accept:" + integer);
//                    }
//                })
                .peek(integer -> System.out.println("accept:" + integer))
                .forEach(System.out::println);
        System.out.println("------------------------------peek(Consumer<? super T> action)------------------------------");
        //2.7 skip(long n)
        //将过滤掉原Stream中的前N个元素，返回剩下的元素所组成的新Stream。
        //如果原Stream的元素个数大于N，将返回原Stream的后（原Stream长度-N）个元素所组成的新Stream；如果原Stream的元素个数小于或等于N，将返回一个空Stream。
        Stream.of(1,2,3,4,5)
                .skip(2)
                .forEach(System.out::println);
        System.out.println("------------------------------skip(long n)------------------------------");
        //2.8 sorted()  sorted(Comparator<? super T> comparator)
        //将对原Stream进行排序，返回一个有序列的新Stream。
        //sorterd有两种变体sorted()，sorted(Comparator)，前者将默认使用Object.equals(Object)进行排序，而后者接受一个自定义排序规则函数(Comparator)，可按照意愿排序。
        Stream.of(3,2,1,5,4)
                .sorted()
                .forEach(System.out::println);
        System.out.println("------------------------------sorted()------------------------------");
        Stream.of(3,2,1,5,4)
//                .sorted(new Comparator<Integer>() {
//                    @Override
//                    public int compare(Integer o1, Integer o2) {
//                        return o2 - o1;//倒序
//                    }
//                })
                .sorted((o1, o2) -> o2 - o1)
                .forEach(System.out::println);
        System.out.println("------------------------------sorted(Comparator<? super T> comparator)------------------------------");

        //3.Terminal
        //3.1 collect
        
        //3.2 count()
        //将返回Stream中元素的个数
        System.out.println("count:" + Stream.of(1,2,3,4,5).count());
        System.out.println("------------------------------count()------------------------------");
        //3.3 forEach(Consumer<? super T> action)
        // 用于遍历Stream中的所元素，避免了使用for循环，让代码更简洁，逻辑更清晰
        Stream.of(1,2,3,4,5)
                .forEach(System.out::println);
        System.out.println("------------------------------forEach(Consumer<? super T> action)------------------------------");
        //3.4 forEachOrdered(Consumer<? super T> action)
        //与forEach类似，都是遍历Stream中的所有元素，不同的是，如果该Stream预先设定了顺序，会按照预先设定的顺序执行（Stream是无序的），默认为元素插入的顺序。
        Stream.of(5,2,1,4,3)
                .forEachOrdered(System.out::println);
        System.out.println("------------------------------forEachOrdered(Consumer<? super T> action)------------------------------");
        //3.5 max(Comparator<? super T> comparator)
        //根据指定的Comparator，返回一个Optional，该Optional中的value值就是Stream中最大的元素。
        //原Stream根据比较器Comparator，进行排序(升序或者是降序)，所谓的最大值就是重新进行排序的，max就是取重新排序后的最后一个值，而min取排序后的第一个值。
        Optional<Integer> max = Stream.of(3,2,1,5,4)
                .max((o1, o2) -> o1 - o2);
        System.out.println("max:" + max.get());
        System.out.println("------------------------------max(Comparator<? super T> comparator)------------------------------");
        //3.6 min(Comparator<? super T> comparator)
        //根据指定的Comparator，返回一个Optional，该Optional中的value值就是Stream中最小的元素。
        //在min中我们找的是Stream中的最大值，不管是最大值还是最小值起决定作用的是Comparator，它决定了元素比较大小的原则。
        Optional<Integer> min = Stream.of(3,2,1,5,4)
                .min(((o1, o2) -> o1 - o2));
        System.out.println("min:" + min.get());
        System.out.println("------------------------------min(Comparator<? super T> comparator)------------------------------");
        //3.7 reduce
        //

        //4.Short-circuiting
        //4.1 allMatch(Predicate<? super T> predicate)
        //用于判断Stream中的元素是否全部满足指定条件。如果全部满足条件返回true，否则返回false。
        boolean allMatch = Stream.of(1, 2, 3, 4)
//                .allMatch(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) {
//                        return integer > 0;
//                    }
//                });
        .allMatch(integer -> integer >0);
        System.out.println("allMatch: " + allMatch);
        System.out.println("------------------------------allMatch(Predicate<? super T> predicate)------------------------------");
        //4.2 anyMatch(Predicate<? super T> predicate)
        //用于判断Stream中的是否有满足指定条件的元素。如果最少有一个满足条件返回true，否则返回false。
        boolean anyMatch = Stream.of(1, 2, 3, 4)
//                .anyMatch(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) {
//                        return integer > 3;
//                    }
//                });
        .anyMatch(integer -> integer > 3);
        System.out.println("allMatch: " + anyMatch);
        System.out.println("------------------------------anyMatch(Predicate<? super T> predicate)------------------------------");
        //4.3 findAny()
        //用于获取含有Stream中的某个元素的Optional，如果Stream为空，则返回一个空的Optional。
        //由于此操作的行动是不确定的，其会自由的选择Stream中的任何元素。
        //在并行操作中，在同一个Stram中多次调用，可能会不同的结果。
        //在串行调用时，默认的是获取第一个元素。
        Optional<Integer> findAny = Stream.of(1, 2, 3, 4)
                .findAny();
        System.out.println(findAny.get());
        System.out.println("------------------------------findAny()------------------------------");
        //4.4 findFirst()
        //用于获取含有Stream中的第一个元素的Optional，如果Stream为空，则返回一个空的Optional。
        //若Stream并未排序，可能返回含有Stream中任意元素的Optional。
        Optional<Integer> findFirst = Stream.of(1, 2, 3, 4)
                .findFirst();
        System.out.println(findFirst.get());
        System.out.println("------------------------------findFirst()------------------------------");
        //4.5 limit(long maxSize)
        //将截取原Stream，截取后Stream的最大长度不能超过指定值N。
        //如果原Stream的元素个数大于N，将截取原Stream的前N个元素；如果原Stream的元素个数小于或等于N，将截取原Stream中的所有元素。
        Stream.of(1,2,3,4,5)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("------------------------------limit(long maxSize)------------------------------");
        //4.6 noneMatch(Predicate<? super T> predicate)
        //将判断Stream中的所有元素是否满足指定的条件，如果所有元素都不满足条件，返回true；否则，返回false
        boolean noneMatch = Stream.of(1, 2, 3, 4, 5)
//                .noneMatch(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) {
//                        return integer > 10;
//                    }
//                });
        .noneMatch(integer -> integer > 10);
        System.out.println("noneMatch: " + noneMatch);
        System.out.println("------------------------------limit(long maxSize)------------------------------");
    }

}
