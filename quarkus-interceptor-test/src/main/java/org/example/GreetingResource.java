package org.example;

import jakarta.inject.Inject;
import jakarta.transaction.SystemException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    MyBean myBean;
    @Inject
    MyTransactionalBean myTransactionalBean;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public void hello() {
        try {
            myTransactionalBean.test();
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
        try {
            myTransactionalBean.test2();
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }

        try {
            myBean.test();
            throw new AssertionError("Not intercepted");
        } catch (InterceptedException e) {
        }
        try {
            myBean.test2();
            throw new AssertionError("Not intercepted");
        } catch (InterceptedException e) {
        }
    }
}
