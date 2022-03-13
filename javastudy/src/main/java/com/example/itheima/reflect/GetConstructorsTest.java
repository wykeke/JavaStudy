package com.example.itheima.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class GetConstructorsTest {
    /**
     *  1、getConstructors
     *  获取全部的构造器：只能获取public修饰的构造器
     *  Constructor[] constructors 用数组类型
     */
    @Test
    public void getConstructors(){
        //  1、获取类对象
        Class c = Student.class;
        //  2、提取类中的全部的构造器对象(只能得到public)
        Constructor[] constructors = c.getConstructors();
        //  3、遍历构造器，拿到名字和参数个数
        for (Constructor constructor : constructors){
            System.out.println(constructor.getName() +"===>" + constructor.getParameterCount());
        }
    }

    /**
     *  2、getDeclaredConstructors
     *  获取全部的构造器：public 和 private
     */
    @Test
    public void getDeclaredConstructors(){
        //  1、获取类对象
        Class c = Student.class;
        //  2、提取类中的全部的构造器对象
        Constructor[] constructors = c.getDeclaredConstructors();
        //  3、遍历构造器，拿到名字和参数个数
        for (Constructor constructor : constructors){
            System.out.println(constructor.getName() +"===>" + constructor.getParameterCount());
        }
    }

    /**
     *  3、getConstructor
     *  获取某个的构造器：按照参数定位无参数构造器,只能拿public修饰的某个构造器
     */
    @Test
    public void getConstructor() throws NoSuchMethodException {
        //  1、获取类对象
        Class c = Student.class;
        //  2、定位单个构造器对象
        Constructor constructor = c.getConstructor(String.class,int.class);
        //  3、拿到名字和参数个数
        System.out.println(constructor.getName() +"===>" + constructor.getParameterCount());
    }

    /**
     *  4、getDeclaredConstructor
     *  获取某个的构造器：都能拿到，不论权限
     */
    @Test
    public void getDeclaredConstructor() throws Exception {
        //  1、获取类对象
        Class c = Student.class;
        //  2、定位单个构造器对象（按照参数定位无参数构造器
        Constructor constructor = c.getDeclaredConstructor();
        //  3、拿到名字和参数个数
        System.out.println("无参：" + constructor.getName() +"===>" + constructor.getParameterCount());
        //无参：com.example.itheima.reflect_class.Student===>0

        //如果遇到了私有的构造器，可以暴力反射
        //反射可以破坏封装性，私有的也可以访问
        constructor.setAccessible(true); // 权限被打开

        Student student = (Student) constructor.newInstance();
        System.out.println(student); //无参构造初始化，没有数据
        /*
            无参构造器执行
            Student{name='null', age=0}
        */

        //  定位某个有参构造器
        Constructor constructor1 = c.getDeclaredConstructor(String.class,int.class);
        System.out.println("有参：" + constructor1.getName() +"===>" + constructor1.getParameterCount());
        //有参：com.example.itheima.reflect_class.Student===>2

        Student student1 = (Student) constructor1.newInstance("张三",20);
        System.out.println(student1);
        /**
         *  有参构造器执行！
         *  Student{name='张三', age=20}
         */

    }

}
