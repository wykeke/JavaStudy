package com.example.itheima.annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 目标：完成注解的解析
 */
public class AnnotationDemo3 {

    @Test
    public void parseClass(){
        //先得到类对象
        Class c = BookStore.class;
        //判断这个类上是否存在这个注解
        if (c.isAnnotationPresent(Bookk.class)){
            //直接获取该注解对象
            Bookk bookk = (Bookk) c.getDeclaredAnnotation(Bookk.class);
            System.out.println(bookk.value()); //《西游记》
            System.out.println(bookk.price()); //50.0
            System.out.println(Arrays.toString(bookk.author())); //[吴承恩]
        }else{
            System.out.println("null");
        }
    }

    @Test
    public void parseMethod() throws NoSuchMethodException {
        // a.先得到类对象
        Class c = BookStore.class;

        Method method = c.getDeclaredMethod("test");

        // b.判断这个类上面是否存在这个注解
        if(method.isAnnotationPresent(Bookk.class)){
            //c.直接获取该注解对象
            Bookk book = (Bookk) method.getDeclaredAnnotation(Bookk.class);
            System.out.println(book.value()); //《红楼梦》
            System.out.println(book.price()); //99.9
            System.out.println(Arrays.toString(book.author())); //[曹雪芹]
        }
    }

}

@Bookk(value = "《西游记》", price = 50.0, author = {"吴承恩"})
class BookStore{
    @Bookk(value = "《红楼梦》", price = 99.9, author = {"曹雪芹"})
    public void test(){

    }

}
