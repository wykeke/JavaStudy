package com.example.itheima.reflect;

/**
 * 目标：反射第一步：获取class对象
 */
public class GetClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //三个方法拿到的都为同一个class对象
        //1、Class类中的一个静态方法：forName(全限名：包名＋类名)
        Class c = Class.forName("com.example.itheima.reflect.Student");
        System.out.println(c); //class com.example.itheima.reflect_class.Student

        //2、类名.class
        Class c1 = Student.class;
        System.out.println(c1);

//        //3.对象.getClass() 获取对象对应类的Class对象
//        Student s = new Student(); //存在私有无参构造方法是不能这样定义
//        Class c2 = s.getClass();
//        System.out.println(c2);
    }
}
