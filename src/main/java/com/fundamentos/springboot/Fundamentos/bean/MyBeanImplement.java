package com.fundamentos.springboot.Fundamentos.bean;

public class MyBeanImplement implements MyBean{

    @Override
    public void print() {
        System.out.println("Hi since my own implementation Bean");
    }
}
