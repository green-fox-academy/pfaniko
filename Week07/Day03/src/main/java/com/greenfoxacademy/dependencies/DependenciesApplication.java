package com.greenfoxacademy.dependencies;

import com.greenfoxacademy.dependencies.coloring_around.MyColor;
import com.greenfoxacademy.dependencies.coloring_around.RedColor;
import com.greenfoxacademy.dependencies.hello_di_project.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependenciesApplication implements CommandLineRunner {
  private Printer printer;
  private MyColor myColor;

  @Autowired
  DependenciesApplication(Printer printer, MyColor myColor) {
    this.printer = printer;
    this.myColor = myColor;
  }

  public static void main(String[] args) {
    SpringApplication.run(DependenciesApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    printer.log("hello");
    myColor.printColor();
  }
}