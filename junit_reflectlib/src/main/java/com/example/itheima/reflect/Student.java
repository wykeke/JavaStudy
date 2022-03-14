package com.example.itheima.reflect;

public class Student {
    private String name;
    private int age;

    public static String schoolName;
    public static final String  COUNTTRY = "中国";

    public Student(){
        System.out.println("无参构造器执行");
    }

    public Student(String name,int age){
        System.out.println("有参构造器执行！");
        this.name = name;
        this.age = age;
    }

    public void run(){
        System.out.println("跑步");
    }

    private void eat(){
        System.out.println("吃饭");
    }

    private String eat(String name){
        System.out.println("吃" + name);
        return "吃的很开心！";
    }

    public static void inAddr(){
        System.out.println("在黑马学习Java!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\''+
                ", age=" + age +
                '}';
    }
}
