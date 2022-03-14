package com.example.itheima.annotation;

/**
 * 自定义注解
 * public @interface 注解名称{
 *     public 属性类型 属性名() default 默认值;
 * }
 */
public @interface MyBook {
    String name();
    String[] authors();
    double price();
}
