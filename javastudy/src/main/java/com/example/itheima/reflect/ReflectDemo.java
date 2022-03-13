package com.example.itheima.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //需求：反射实现泛型擦除后，加入其他类型的元素
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        System.out.println(list1.getClass() == list2.getClass()); // true 都为ArrayList.class

        System.out.println("---------------------------");
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(22);
        list3.add(23);
//        list3.add("字符串"); //报错

        Class c = list3.getClass(); //ArrayList.class ==> public boolean add(E e)

        //定位c类中的add方法
        Method addMethod = c.getDeclaredMethod("add",Object.class);
        boolean rs = (boolean) addMethod.invoke(list3,"字符串");
        System.out.println(rs); //true

        System.out.println(list3); //[22, 23, 字符串]

        ArrayList list4 = list3;
        list4.add("字符");
        list4.add(false);
        System.out.println(list3); //[22, 23, 字符串, 字符, false]
        System.out.println(list4); //[22, 23, 字符串, 字符, false]
        //此时ArrayList已经不受约束
    }
}
