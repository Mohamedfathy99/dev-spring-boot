package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdice(JoinPoint theJoinPoint, List<Account> result){

        // print out which we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Execution @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n=====>>> Results is: " + result);

    }

    // match for any method in package .* -> for any class - .* -> for any method - (..) for any params
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n=====> Executing @Before advice on method()");

        // display the method signatures
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop through args
        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) arg;
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account name: " + theAccount.getLevel());

            }
        }
    }
}
