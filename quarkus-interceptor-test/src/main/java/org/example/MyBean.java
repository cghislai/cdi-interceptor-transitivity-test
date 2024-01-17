package org.example;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyBean {

    @MyBinding
    public void test() {
        throw new AssertionError("Not intercepted");
    }

    @MyTransitiveBinding
    public void test2() {
        throw new AssertionError("Not intercepted");
    }
}
