package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.jboss.weld.environment.se.events.ContainerInitialized;

@ApplicationScoped
public class InterceptorBindingTransitivity {

    @Inject
    private MyBean myBean;

    public void test(@Observes ContainerInitialized event) {
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
