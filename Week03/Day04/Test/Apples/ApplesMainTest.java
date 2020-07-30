package Apples;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ApplesMainTest {
  ApplesMain apple1 = new ApplesMain();

  @Test
  void test1() {
    assertEquals("apple", apple1.getApple());
  }
}