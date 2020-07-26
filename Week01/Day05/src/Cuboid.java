public class Cuboid {
  public static void main(String[] args) {
// Write a program that stores 3 sides of a cuboid as variables (doubles)
// The program should write the surface area and volume of the cuboid like:
//
// Surface Area: 600
// Volume: 1000

    double height = 10;
    double length = 10;
    double depth = 10;
    double surfaceArea = 2 * ((length * depth) + (depth * height) + (height * length));
    double volume = length * depth * height;
    System.out.println( "Surface Area: " + Math.round(surfaceArea));
    System.out.println( "Volume: " + Math.round(volume));
  }
}