package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MyUnsafeTransactionalBean {

    @Transactional
    public void test() {
        throw new TransactionalSafeException("test");
    }

    @MyTransactionalBinding
    public void test2() {
        throw new TransactionalSafeException("test");
    }


    public void test3() {
        throw new TransactionalSafeException("test");
    }
}
