package com.carFactory.diyCar.utils.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@CustomInterceptor
public class LoggingInterceptor implements Serializable {

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext)
            throws Exception {
        System.out.println("Entering method: "
                + invocationContext.getMethod().getName() + " in class "
                + invocationContext.getMethod().getDeclaringClass().getName());

        Object result = invocationContext.proceed();

//        System.out.println("Do stuff after method.");

        return result;
    }
}
