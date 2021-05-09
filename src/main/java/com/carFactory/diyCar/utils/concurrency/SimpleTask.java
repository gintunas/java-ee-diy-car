package com.carFactory.diyCar.utils.concurrency;

import lombok.SneakyThrows;

import javax.annotation.Resource;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class SimpleTask implements Runnable{

//    @Resource
//    UserTransaction userTransaction;

    @Override
    public void run() {
//        int status = 0;
//        try {
//            status = userTransaction.getStatus();
//        } catch (SystemException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Transaction status: " + status);
//        try {
//            userTransaction.begin();
//        } catch (NotSupportedException e) {
//            e.printStackTrace();
//        } catch (SystemException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Began transaction.");

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Doing work: " + i);
        }
    }
}
