package com.example.itheima.annotation;

@MyBook(name = "《学习java》", authors = {"w","y"}, price = 99.9)
//@Book("/delete") 注解中只有一个value时可不用指定名称
@Book(value = "/delete", price = 23.5)
//@Book("/delete") //注解中除了value其他都有默认值时不用指定名称
public class AnnotationDemo1 {
    @MyBook(name="《精通JavaSE2》",authors = {"黑马", "dlei"} , price = 199.5)
    private AnnotationDemo1(){

    }

    @MyBook(name="《精通JavaSE1》",authors = {"黑马", "dlei"} , price = 199.5)
    public static void main(String[] args) {
        @MyBook(name="《精通JavaSE2》",authors = {"黑马", "dlei"} , price = 199.5)
        int age = 21;
    }
}
