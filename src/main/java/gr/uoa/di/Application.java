package gr.uoa.di;

import gr.uoa.di.controllers.ProfileController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new File(ProfileController.imagedir).mkdirs();
        SpringApplication.run(Application.class, args);
    }
}