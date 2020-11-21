package com.example.lists;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Liutx
 * @date 2020/10/23 23:57
 * @Description
 */
//        User user1 = User.builder().id(1).name("ONE").sex("1").build();
//        User user2 = User.builder().id(2).name("ZERO").sex("0").build();
//        User user3 = User.builder().id(3).name("TWO").sex("0").build();
//        User user4 = User.builder().id(4).name("FOUR").sex("1").build();
//        User user5 = User.builder().id(5).name("ONE").sex("1").build();
//
//        //使用lombok没有无参构造方法，只有具有全部参数的构造方法
//        User user = new User("1",1,"1");
//
//        userList.add(user1);
//        userList.add(user2);
//        userList.add(user3);
//        userList.add(user4);
//        userList.add(user5);
//        System.out.println("筛选前：" + userList);
//        userList = userList.stream().filter(o -> o.getName().equals("ONE")).collect(Collectors.toList());
//        System.out.println("筛选后：" + userList);

@Slf4j
public class test {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

//
//        List<String> list = Arrays.asList(" ","a","b");
//        System.out.println(list);
//        Collections.replaceAll(list, "\\s", "!!!!!");
//        System.out.println(list);


//        List<String> sLst = new ArrayList<String>();
//        sLst.add("A");
//        sLst.add("B");
//        sLst.add("C");
//        sLst.add("A");
//        // This will replace all "A" with "Z"
//        Collections.replaceAll(sLst, "A", "Z");
//        System.out.println(sLst);// [Z, B, C, Z]
//        String s = "[aasa, bbbbb]";
//        String s1 = s.replaceAll("(?:\\[|null|\\]| +)", "");

//        ArrayList<String> arrayList = new ArrayList<String>();
//        arrayList.add("A");
//        arrayList.add("B");
//        arrayList.add("A");
//        arrayList.add("C");
//        arrayList.add("D");

//        Collections.replaceAll(arrayList, "A", null);

//        System.out.println(arrayList);
//        System.out.println(s1);


//频繁调用Collection.contains() 反例
        List<Object> list = new ArrayList<>();
        Date start = new Date();
        log.warn(start.toString());
        for (int i = 0; i <= 12800; i++) {
            //时间复杂度为O(n)
            if (list.contains(i))
                System.out.println("list contains " + i);

        }
        Date end = new Date();
        log.warn(end.toString());
//        log.info((end.toString()-start.toString());
    }

}
