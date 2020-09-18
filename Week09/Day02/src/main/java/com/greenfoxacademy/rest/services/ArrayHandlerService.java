package com.greenfoxacademy.rest.services;

import com.greenfoxacademy.rest.models.arrayhandler.ArrayHandler;
import com.greenfoxacademy.rest.models.arrayhandler.ArrayHandlerArrayResult;
import com.greenfoxacademy.rest.models.arrayhandler.ArrayHandlerIntResult;
import org.springframework.stereotype.Service;

@Service
public class ArrayHandlerService {

  public Object calculateResults(ArrayHandler arrayHandler) {
    if (arrayHandler.getWhat().equals("sum")) {
      return new ArrayHandlerIntResult(sum(arrayHandler));
    } else if (arrayHandler.getWhat().equals("multiply")) {
      return new ArrayHandlerIntResult(multiply(arrayHandler));
    } else {
      return new ArrayHandlerArrayResult(doubleArray(arrayHandler));
    }
  }

  private int sum(ArrayHandler arrayHandler) {
    int sum = 0;
    for (int i = 0; i < arrayHandler.getNumbers().length; i++) {
      sum = sum + arrayHandler.getNumbers()[i];
    }
    return sum;
  }

  private int multiply(ArrayHandler arrayHandler) {
    int multiplied = 1;
    for (int i = 0; i < arrayHandler.getNumbers().length; i++) {
      multiplied = multiplied * arrayHandler.getNumbers()[i];
    }
    return multiplied;
  }

  private int[] doubleArray(ArrayHandler arrayHandler) {
    int [] doubledArray = new int[arrayHandler.getNumbers().length];
    for (int i = 0; i < arrayHandler.getNumbers().length; i++) {
      doubledArray[i] = arrayHandler.getNumbers()[i] * 2;
    }
    return doubledArray;
  }
}