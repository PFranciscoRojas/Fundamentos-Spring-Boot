package com.fundamentos.springboot.Fundamentos.bean;

import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithProperties;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {

    private String name;
    private String apellido;
    private String random;

    public MyBeanWithPropertiesImplement(String name, String apellido, String random) {
        this.name = name;
        this.apellido = apellido;
        this.random = random;
    }

    @Override
    public String function() {
        return name + " --- "+ apellido+" --- "+random;
    }
}
