package gr.uoa.di;

import gr.uoa.di.controllers.ProfileController;
import gr.uoa.di.controllers.UploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new File(UploadController.uploadingdir).mkdirs();
        new File(ProfileController.imagedir).mkdirs();
        SpringApplication.run(Application.class, args);
    }
}