package gr.uoa.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.io.File;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static final String imagedir = System.getProperty("user.dir") + "/src/main/webapp/assets/imagedir/";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        new File(imagedir).mkdirs();
        SpringApplication.run(Application.class, args);
    }
}