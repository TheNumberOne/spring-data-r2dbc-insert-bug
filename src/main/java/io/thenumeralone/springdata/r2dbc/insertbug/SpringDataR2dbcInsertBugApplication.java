package io.thenumeralone.springdata.r2dbc.insertbug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication()//scanBasePackages = "io.thenumeralone.springdata.r2dbc")
public class SpringDataR2dbcInsertBugApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataR2dbcInsertBugApplication.class, args);
    }
}
