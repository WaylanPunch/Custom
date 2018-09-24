package com.tasksdemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    /**
     *
     * @throws InterruptedException
     */
    @Async
    public void sayhi() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Hello World.");
    }


    /**
     *
     * @throws InterruptedException
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void sayhi2() throws InterruptedException {
        //Thread.sleep(3000);
        System.out.println("Hello World.....");
    }

}
