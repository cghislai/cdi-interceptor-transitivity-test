package org.example;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@MyTransitiveBinding
public class MyBean {

    public void test() {
        throw new AssertionError("Not intercepted");
    }

    @MyBinding
    public void test2() {
        throw new AssertionError("Not intercepted");
    }
}
