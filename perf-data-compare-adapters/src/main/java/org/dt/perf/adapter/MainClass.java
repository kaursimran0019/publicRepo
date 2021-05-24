package org.dt.perf.adapter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication(scanBasePackages = "org.dt")
//@EnableJpaRepositories(basePackages = "org.dt")
//@Configuration
@ComponentScan(basePackages = "org.dt")
@EntityScan(basePackages = "org.dt")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MainClass {
    public static void main(String[] args) {
        System.out.println("!!ADAPTOR MAIN WORKING!!");
        SpringApplication.run(MainClass.class, args);
    }
    public @ResponseBody String addNewUser(@RequestParam String name)
    {
        return "COOL";
    }
}
