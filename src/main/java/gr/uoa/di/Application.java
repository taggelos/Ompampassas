package gr.uoa.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class Application {
    public static final String imagedir = System.getProperty("user.dir") + "/src/main/webapp/assets/imagedir/";

    public static void main(String[] args) {
        new File(imagedir).mkdirs();
        SpringApplication.run(Application.class, args);
    }
}