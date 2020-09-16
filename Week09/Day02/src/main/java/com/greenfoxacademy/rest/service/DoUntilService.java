package com.greenfoxacademy.rest.service;

import com.greenfoxacademy.rest.models.DoUntil;
import com.greenfoxacademy.rest.models.DoUntilResult;
import org.springframework.stereotype.Service;

@Service
public class DoUntilService {

  public DoUntilResult doActionUntilNumber(String action, DoUntil doUntil) {
    if (action.equals("sum")) {
      return new DoUntilResult(sum(doUntil));
    } else {
      return new DoUntilResult(factor(doUntil));
    }
  }

  private int factor(DoUntil doUntil) {
    int factor = 1;
    for (int i = 1; i <= doUntil.getUntil(); i++) {
      factor = factor * i;
    }
    return factor;
  }

  private int sum(DoUntil doUntil) {
    int sum = 0;
    for (int i = 0; i <= doUntil.getUntil(); i++) {
      sum = sum + i;
    }
    return sum;
  }
}