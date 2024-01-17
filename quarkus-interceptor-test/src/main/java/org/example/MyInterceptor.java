package org.example;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.Dependent;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Dependent
@Interceptor
@MyBinding
@Priority(1)
public class MyInterceptor {

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext) throws Exception {
        throw new InterceptedException("Intercepted");
    }
}
