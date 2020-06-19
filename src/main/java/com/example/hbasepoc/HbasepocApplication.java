package com.example.hbasepoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HbasepocApplication implements CommandLineRunner {

  @Autowired
  private HBasePOCService hBasePOCService;
  public static void main(String[] args) {
    SpringApplication.run(HbasepocApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
//    hBasePOCService.write();

    hBasePOCService.insert();
    hBasePOCService.query();
    hBasePOCService.delete();
    hBasePOCService.query();
  }
}
