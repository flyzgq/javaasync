package com.fly.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author fly
 * @date 2018/6/24 11:34
 * @description
 **/
public class ExecutorAsyncTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorAsyncTask.class);

    ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private ExecutorService executorService = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());

    public void asyncTask(){
        executorService.submit(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);//方便观察结果
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                int sum = 0;
                for(int i = 0; i < 1000; i++) {

                    sum += i;
                }

                System.out.println(sum);
                if(LOGGER.isDebugEnabled()){
                    LOGGER.debug("*******************************the pool name is : {}", Thread.currentThread().getName());
                }

            }
        });
    }

}
