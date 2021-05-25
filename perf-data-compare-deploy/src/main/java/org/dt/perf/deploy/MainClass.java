package org.dt.perf.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class MainClass {
    public static void main(String[] args) {
        System.out.println("Working!!");
        SpringApplication.run(MainClass.class);
    }
}
