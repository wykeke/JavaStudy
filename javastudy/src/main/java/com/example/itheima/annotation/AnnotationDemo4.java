package com.example.itheima.annotation;

import java.lang.reflect.Method;

public class AnnotationDemo4 {
    
    @MyTest
    public void test1(){
        System.out.println("===test1===");
    }

    public void test2(){
        System.out.println("===test2===");
    }

    @MyTest
    public void test3(){
        System.out.println("===test3===");
    }
    
    //启动菜单，有注解的才被调用
    public static void main(String[] args) throws Exception {
        AnnotationDemo4 annotationDemo4 = new AnnotationDemo4();
        //获取类对象
        Class c = AnnotationDemo4.class;
        //提取全部方法
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)){
                //有注解的被调用
                method.invoke(annotationDemo4);
            }
        }
        /**
         * ===test1===
         * ===test3===
         */
    }
}
