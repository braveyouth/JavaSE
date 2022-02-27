package com.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangy
 * @date 2021-09-24 10:02
 * @apiNote:
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("小鱼人");
        list.add("小鱼人");
        list.add("小鱼人");
        list.stream()
                .forEach(System.out::println);
        System.out.println(list.toString());

        Map<String, String> map = new HashMap<>(16);
        map.put("name","jack");
        map.put("age","18");
        map.put("sex","man");
        System.out.println(map.toString());
        map.remove("sex");
        map.put("hobby","study");
        System.out.println(map.toString());
    }

}
