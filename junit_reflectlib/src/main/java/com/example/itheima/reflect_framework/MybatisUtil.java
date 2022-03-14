package com.example.itheima.reflect_framework;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class MybatisUtil {

    /**
     * 保存任意类型的对象
     * @param obj
     */
    public static void save(Object obj){
        try(
                //打印输出流
                PrintStream printStream = new PrintStream(new FileOutputStream("C:\\Users\\YDZ\\AndroidStudioProjects\\JavaStudy\\junit-reflect\\src\\data",true));
                ){
            //1、提取这个对象的全部成员变量：只有反射可以解决
            Class c = obj.getClass(); //c.getSimpleName()获取当前类名   c.getName获取全限名：包名+类名
            printStream.println("================" + c.getSimpleName() + "================");

            //2、提取它的全部成员变量
            Field[] fields = c.getDeclaredFields();
            //3、获取成员变量的信息
            for (Field field : fields) {
                String name = field.getName();
                //提取本成员变量在ob将对象中的值（取值）
                field.setAccessible(true);
                String value = field.get(obj) + "";
                printStream.println(name + " " + value);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
