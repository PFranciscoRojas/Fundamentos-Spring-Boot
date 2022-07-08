package com.fundamentos.springboot.Fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

     private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    private MyOperation myoperation;

    public MyBeanWithDependencyImplement(MyOperation myoperation) {
        this.myoperation = myoperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("We entered to the method printWithDependency");
        int operation = myoperation.sum(5);
        LOGGER.debug("The number sent like parameters to the dependency is :"+operation);

        System.out.println("Operation" + operation);
        System.out.println("hi since implementation with dependency");
    }
}
