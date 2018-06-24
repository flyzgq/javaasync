package com.fly.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fly
 * @date 2018/6/24 12:04
 * @description
 **/
public class Client {

    public static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1; i++) {
            Client client = new Client();
            client.task2();
            ExecutorAsyncTask asyncTask = new ExecutorAsyncTask();
            asyncTask.asyncTask();

            client.task3();
        }
    }

    private void task2(){
        LOGGER.debug("*****************the task is task3 *******************");
    }

    private void task3() throws InterruptedException {
        LOGGER.debug("*****************task3 start*******************");
        Thread.sleep(50);
        LOGGER.debug("*****************task3 stop*******************");
    }
}
