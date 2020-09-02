package com.greenfoxacademy.dependencies.coloring_around;

import com.greenfoxacademy.dependencies.hello_di_project.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreenColor implements MyColor {
  private Printer printer;

  @Autowired
  GreenColor (Printer printer){
    this.printer = printer;
  }

  @Override
  public void printColor() {
    printer.log("It is green in color ...");
  }
}