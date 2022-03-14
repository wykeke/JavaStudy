package com.example.itheima.proxy;

public class Test {
    public static void main(String[] args) {
        //把业务对象直接做成一个代理对象返回，返回对象的类型也是UserService类型
        UserService userService = ProxyUtil.getProxy(new UserServiceImpl());
        System.out.println(userService.login("admin","1234"));
        System.out.println(userService.deleteUsers());
        userService.selectUsers();
        userService.updateUsers();

        /**
         * login方法耗时：1.016s
         * success
         * 删除100个用户数据！
         * deleteUsers方法耗时：0.512s
         * true
         * 查询了100个用户数据！
         * selectUsers方法耗时：2.013s
         * 修改100个用户数据！
         * updateUsers方法耗时：2.512s
         */
    }
}
