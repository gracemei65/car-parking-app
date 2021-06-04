package com.gracie.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
public class LargeFileProcessor implements CommandLineRunner {

    @Autowired
    private StudentService service;

    @Override
    public void run(String... args) throws Exception {

        log.info("Starting runner...");
       // processLargeFile();


    }

    public void processLargeFile() throws Exception{

        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        CopyOnWriteArrayList items = new CopyOnWriteArrayList<>();
        // List<String> items= Collections.synchronizedList(new ArrayList<String>());
        Files.lines(Paths.get("/tmp/students.csv"))
                .forEach(line ->
                {
                    // log.info(line);
                    items.add(line);
                    if (items.size() % 3 == 0) {
                        log.info("process items {} thread {} ", items.size(), Thread.currentThread().getName());
                        //log.info(items.toString());

                        futures.add(CompletableFuture.supplyAsync(() -> saveStudents(items)));
                        sleep(1l);
                        items.clear();
                    }

                });
        if (items.size() > 0) {
            //add completable task for remaining rows
            log.info("remaining items {} thread {} ", items.size(), Thread.currentThread().getName());
            futures.add(CompletableFuture.supplyAsync(() -> saveStudents(items)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).get();
    }

    public Integer saveStudents(CopyOnWriteArrayList<String> items) {

        log.info("save... items {} by {}", items.size(), Thread.currentThread().getName());
        log.info(items.toString());
        return 1;
    }

    private void sleep(Long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
