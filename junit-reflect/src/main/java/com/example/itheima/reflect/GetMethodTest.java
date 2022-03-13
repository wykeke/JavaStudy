package com.example.itheima.reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 目标：反射——获取Method方法对象
 *
 *     反射获取类的Method方法对象：
 *          1、Method getMethod(String name,Class...args);
 *              根据方法名和参数类型获得对应的方法对象，只能获得public的
 *
 *          2、Method getDeclaredMethod(String name,Class...args);
 *              根据方法名和参数类型获得对应的方法对象，包括private的
 *
 *          3、Method[] getMethods();
 *              获得类中的所有成员方法对象，返回数组，只能获得public修饰的且包含父类的
 *
 *          4、Method[] getDeclaredMethods();
 *             获得类中的所有成员方法对象，返回数组,只获得本类申明的方法。
 *
 *     Method的方法执行：
 *         Object invoke(Object obj, Object... args)
 *           参数一：触发的是哪个对象的方法执行。
 *           参数二： args：调用方法时传递的实际参数
 */
public class GetMethodTest {
    /**
     * 1.获得类中的所有成员方法对象
     */
    @Test
    public void getDeclaredMethods(){
        // a.获取类对象
        Class c = Student.class;
        // b.提取全部方法；包括私有的
        Method[] methods = c.getDeclaredMethods();
        // c.遍历全部方法
        for (Method method : methods) {
            System.out.println(method.getName() +" 返回值类型：" + method.getReturnType() + " 参数个数：" + method.getParameterCount());
        }
        /**
         * run 返回值类型：void 参数个数：0
         * toString 返回值类型：class java.lang.String 参数个数：0
         * getName 返回值类型：class java.lang.String 参数个数：0
         * setName 返回值类型：void 参数个数：1
         * inAddr 返回值类型：void 参数个数：0
         * getAge 返回值类型：int 参数个数：0
         * setAge 返回值类型：void 参数个数：1
         * eat 返回值类型：class java.lang.String 参数个数：1
         * eat 返回值类型：void 参数个数：0
         */
    }

    /**
     * 2. 获取某个方法对象
     */
    @Test
    public void getDeclardMethod() throws Exception {
        // a.获取类对象
        Class c = Student.class;
        // b.提取单个方法对象
        Method method = c.getDeclaredMethod("eat");
        /**
         * 无参构造器执行
         * 吃饭
         */
        Method method1 = c.getDeclaredMethod("eat", String.class);

        // 暴力打开权限了
        method.setAccessible(true);
        method1.setAccessible(true);

        // c.触发方法的执行
        Student student = new Student();
        // 注意：方法如果是没有结果回来的，那么返回的是null.
        Object result = method.invoke(student);
        System.out.println(result);
        /**
         * null
         */

        Object result2 = method1.invoke(student, "水果");
        System.out.println(result2);
        /**
         * 吃水果
         * 吃的很开心！
         */
    }
}
