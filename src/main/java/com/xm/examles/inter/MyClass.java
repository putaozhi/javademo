package com.xm.examles.inter;

/**
 * @ClassName MyClass
 * @Description TODO
 * @Date 2020/8/26 18:36
 */
public class MyClass implements InterfaceTest.InnerInteerface {
    @Override
    public void aa() {
        System.out.println("接口的方法");
    }

    public static void main(String[] args) {

        MyClass a = new MyClass();
        a.aa();

    }
}