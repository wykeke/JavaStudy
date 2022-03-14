package com.example.itheima.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 目标：反射_获取Field成员变量对象。
 *
 *      反射的第一步是先得到Class类对象。
 *
 *      1、Field getField(String name);
 *             根据成员变量名获得对应Field对象，只能获得public修饰
 *      2.Field getDeclaredField(String name);
 *             根据成员变量名获得对应Field对象，只要申明了就可以得到
 *      3.Field[] getFields();
 *             获得所有的成员变量对应的Field对象，只能获得public的
 *      4.Field[] getDeclaredFields();
 *             获得所有的成员变量对应的Field对象，只要申明了就可以得到
 *      小结：
 *         获取全部成员变量：getDeclaredFields
 *         获取某个成员变量：getDeclaredField
 *
 *     目标：反射获取成员变量: 取值和赋值。
 *
 *     Field的方法：给成员变量赋值和取值
 *         void set(Object obj, Object value)：给对象注入某个成员变量数据
 *         Object get(Object obj):获取对象的成员变量的值。
 *         void setAccessible(true);暴力反射，设置为可以直接访问私有类型的属性。
 *         Class getType(); 获取属性的类型，返回Class对象。
 *         String getName(); 获取属性的名称。
 *
 */
public class GetFieldTest {

    /**
     * 1.获取全部的成员变量。
     * Field[] getDeclaredFields();
     *  获得所有的成员变量对应的Field对象，只要申明了就可以得到
     */
    @Test
    public void getDeclaredFields(){
        // a.定位Class对象
        Class c = Student.class;
        // b.定位全部成员变量
        Field[] fields = c.getDeclaredFields();
        // c.遍历一下
        for (Field field : fields) {
            System.out.println(field.getName() + "==>" + field.getType());
        }
        /**
         * name==>class java.lang.String
         * age==>int
         * schoolName==>class java.lang.String
         * COUNTTRY==>class java.lang.String
         */
    }

    /**
     2.获取某个成员变量对象 Field getDeclaredField(String name);
     */
    @Test
    public void getDeclaredField() throws Exception {
        // a.定位Class对象
        Class c = Student.class;
        // b.根据名称定位某个成员变量
        Field f = c.getDeclaredField("age");
        System.out.println(f.getName() +"===>" + f.getType());
        /**
         * age===>int
         */

        f.setAccessible(true); // 暴力打开权限

        // c.赋值
        Student s = new Student();
        f.set(s , 18);  // s.setAge(18);
        System.out.println(s);
        /**
         * 无参构造器执行
         * Student{name='null', age=18}
         */

        // d、取值
        int age = (int) f.get(s);
        System.out.println(age);
        /**
         * 18
         */
    }


}
