package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MyTransactionalBean {

    @Inject
    TransactionManager tm;
    @Inject
    MyUnsafeTransactionalBean myUnsafeTransactionalBean;

    @Transactional
    public void test() throws SystemException {
        Transaction transaction = tm.getTransaction();
        if (transaction == null) {
            throw new AssertionError("No tranasction");
        }
    }

    @MyTransactionalBinding
    public void test2() throws SystemException {
        Transaction transaction = tm.getTransaction();
        if (transaction == null) {
            throw new AssertionError("No tranasction");
        }
    }


    public void test3() throws SystemException {
        Transaction transaction = tm.getTransaction();
        if (transaction != null) {
            throw new AssertionError("Tranasction");
        }
    }

    public void test4() {
        try {
            myUnsafeTransactionalBean.test();
            throw new AssertionError("nothing thrown");
        } catch (TransactionalSafeException e) {
        }
        try {
            myUnsafeTransactionalBean.test2();
            throw new AssertionError("nothing thrown");
        } catch (TransactionalSafeException e) {
        }
        try {
            myUnsafeTransactionalBean.test3();
            throw new AssertionError("nothing thrown");
        } catch (TransactionalSafeException e) {
        }
    }

}
