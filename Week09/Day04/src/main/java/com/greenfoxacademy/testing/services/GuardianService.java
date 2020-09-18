package com.greenfoxacademy.testing.services;

import com.greenfoxacademy.testing.models.SpeedData;
import org.springframework.stereotype.Service;

@Service
public class GuardianService {

  public SpeedData createSpeedData(double distance, double time) {
    double speed = calculateSpeedData(distance, time);
    return new SpeedData(distance, time, speed);
  }

  private double calculateSpeedData(double distance, double time) {
    return distance / time;
  }
}
