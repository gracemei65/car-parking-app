package com.gracie.demo.service;


import com.gracie.demo.entity.Student;
import com.gracie.demo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    @Async
    public void sendMessage(String mobile) {
        sleep(5000);
        log.info(" sent message to your phone {} by thread : {}", mobile, Thread.currentThread().getName());
        int num = 10 / 0;
        log.info("num" + num);

    }

    private void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public CompletableFuture<List<Student>> saveStudents(MultipartFile file) {
        long start = System.currentTimeMillis();
        List<Student> students = parseCsv(file);
        log.info("saving students size {} by {}", students.size(), " " + Thread.currentThread().getName());
        repository.saveAll(students);
        long end = System.currentTimeMillis();
        log.info("Total time {}", (end - start));
        return CompletableFuture.completedFuture(students);

    }

    @Async
    public CompletableFuture<List<Student>> saveStudents(List<String> lines) {
        long start = System.currentTimeMillis();
        List<Student> students = parseCsv(lines);
        log.info("saving students size {} by {}", students.size(), " " + Thread.currentThread().getName());
        repository.saveAll(students);
        long end = System.currentTimeMillis();
       // log.info("Total time {}", (end - start));
        return CompletableFuture.completedFuture(students);

    }

    @Async
    public CompletableFuture<List<Student>> getAllStudents() {
        log.info("getlist of students by " + Thread.currentThread().getName());
        List<Student> students = repository.findAll();
        log.info("students size " + students.size());
        return CompletableFuture.completedFuture(students);
    }

    private List<Student> parseCsv(List<String> lines) {
        List<Student> students = lines.stream().map(line -> {
            String data[] = line.split(",");
            Student student = new Student();
            student.setName(data[0]);
            student.setEmail(data[1]);
            student.setGender(data[2]);
            return student;
        }).collect(Collectors.toList());
        return students;

    }

    private List<Student> parseCsv(MultipartFile file) {
        List<Student> students = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            students = br.lines().map(line ->
                    {
                        String data[] = line.split(",");
                        Student student = new Student();
                        student.setName(data[0]);
                        student.setEmail(data[1]);
                        student.setGender(data[2]);
                        return student;
                    }
            ).collect(Collectors.toList());

            return students;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void sleep(Long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
