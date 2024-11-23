package org.sdc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side a: ");
        double sideA = scanner.nextDouble();

        System.out.print("Enter side b: ");
        double sideB = scanner.nextDouble();

        System.out.print("Enter side c: ");
        double sideC = scanner.nextDouble();

        determineTriangleType(sideA, sideB, sideC);
    }

    static void determineTriangleType(double a, double b, double c) {
        if (!isTriangleValid(a, b, c)) {
            System.out.println("The triangle is not valid.");
            return;
        }

        if (a == b && b == c) {
            System.out.println("Equilateral triangle");
        } else if (a == b || b == c || a == c) {
            System.out.println("Isosceles triangle");
        } else {
            System.out.println("Scalene triangle");
        }
    }

    static boolean isTriangleValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}