package com.example.itheima.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解：注解注解的注解
 * @ Target约束自定义注解可以标记的范围。
 * @ Retention用来约束自定义注解的存活范围。
 *
 * @ Target中可使用的值定义在ElementType枚举类中，常用值如下
 * TYPE，类，接口
 * FIELD, 成员变量
 * METHOD, 成员方法
 * PARAMETER, 方法参数
 * CONSTRUCTOR, 构造器
 * LOCAL_VARIABLE, 局部变量
 *
 * @ Retention中可使用的值定义在RetentionPolicy枚举类中，常用值如下
 * SOURCE： 注解只作用在源码阶段，生成的字节码文件中不存在
 * CLASS： 注解作用在源码阶段，字节码文件阶段，运行阶段不存在，默认值.
 * RUNTIME：注解作用在源码阶段，字节码文件阶段，运行阶段（开发常用）
 */

@Target({ElementType.METHOD,ElementType.FIELD}) //元注解 METHOD 方法  FIELD 成员变量
@Retention(RetentionPolicy.RUNTIME) //一直活着，在运行阶段这个注解也不消失
public @interface MyTest {

}
