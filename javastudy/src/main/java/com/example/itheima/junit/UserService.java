package com.example.itheima.junit;

/**
 *  业务方法
 */
public class UserService {
    public String loginName(String loginName, String passWord){
        if ("admin".equals(loginName) && "123456".equals(passWord)){
            return "登录成功";
        }else{
            return "用户名或密码有问题";
        }
    }

    public void selectName(){
        System.out.println(10/0);
        System.out.println("查询全部用户名称成功");
    }
}
