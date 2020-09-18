package com.greenfoxacademy.testing.models;

public class SpeedData {
  private double distance;
  private double time;
  private double speed;

  public double getDistance() {
    return distance;
  }

  public double getTime() {
    return time;
  }

  public double getSpeed() {
    return speed;
  }

  public SpeedData(double distance, double time, double speed) {
    this.distance = distance;
    this.time = time;
    this.speed = speed;
  }
}
