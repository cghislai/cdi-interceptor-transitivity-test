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
}
