package gr.uoa.di.controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;


@Controller
public class ConfirmationController {
    public static final String receiptdir = System.getProperty("user.dir") + "/src/main/resources/assets/receipts/";

    @GetMapping("/confirmation")
    public String getConfirmation() {
        return "confirmation";
    }

    @PostMapping("/confirmation")
    public ResponseEntity<InputStreamResource> downloadPdf() {
        RunnableOperation R1 = new RunnableOperation("Thread-1");
        R1.start();
        try {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("confirmation");
            //mav.addObject("user", user);
            File file = new File(String.valueOf(receiptdir + "test.pdf"));
            HttpHeaders respHeaders = new HttpHeaders();
            MediaType mediaType = MediaType.parseMediaType("application/pdf");
            respHeaders.setContentType(mediaType);
            respHeaders.setContentLength(file.length());
            respHeaders.setContentDispositionFormData("attachment", file.getName());
            InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
            return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
        } catch (Exception e) {
            //String message = "Errore nel download del file "+idForm+".csv; "+e.getMessage();
            //logger.error(message, e);
            return new ResponseEntity<InputStreamResource>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

class RunnableOperation implements Runnable {
    private Thread t;
    private String threadName;

    RunnableOperation(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}