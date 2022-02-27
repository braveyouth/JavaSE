package com.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangy
 * @Time 2021-05-06 15:53
 * @Description:
 */
public class MethodApi {

    public static void main(String[] args) {
        System.out.println("开始");

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            strings.add(String.valueOf(i) + "哈哈哈哈哈哈");
        }
//        List<Integer> integers = new ArrayList<>();
//        for (int i = 0; i < 100000; i++) {
//            integers.add(i);
//        }
        long start = System.currentTimeMillis();
//        System.out.println(page(strings, 1, 50000));
        List<?> objects = pageBySubList(strings, 3, 10);
        System.out.println(objects);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        Collections.sort(strings, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
//        System.out.println(strings);
    }


    /**
     * 第一种方法是循环截取某页列表进行分页
     * @param dataList 分页数据
     * @param currentPage   当前页面
     * @param pageSize  页面大小
     */
    public static List<String> page(List<String> dataList, int currentPage, int pageSize) {
        List<String> currentPageList = new ArrayList<>();
        if (dataList != null && dataList.size() > 0) {
            int currIdx = (currentPage > 1 ? (currentPage - 1) * pageSize : 0);
            for (int i = 0; i < pageSize && i < dataList.size() - currIdx; i++) {
                String data = dataList.get(currIdx + i);
                currentPageList.add(data);
            }
        }
        return currentPageList;
    }


    /**
     * 第二种是利用List中的sublist方法进行分页：
     * @param list 分页数据
     * @param currentPage   当前页面
     * @param pagesize  页面大小
     */
    public static List<?> pageBySubList(List<?> list, int currentPage, int pagesize) {
        //手动实现分页
        if (currentPage <= 0 || currentPage > list.size() || pagesize <= 0) {
            return new ArrayList<>(0);
        }
        int fromIndex = (currentPage - 1) * pagesize;
        int toIndex=(list.size() - fromIndex) > pagesize ? fromIndex + pagesize:list.size();
        //获得分页后的list
        if(fromIndex <= toIndex){
            list = list.subList(fromIndex, toIndex);
        }else {
            list = Collections.emptyList();
        }
        return list;
    }

}
