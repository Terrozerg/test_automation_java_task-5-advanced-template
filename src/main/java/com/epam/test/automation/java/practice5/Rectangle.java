package com.epam.test.automation.java.practice5;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double a, double b) {
        if(a<0 || b<0){
            throw new IllegalArgumentException("Cannot create rectangle with negative sides.");
        }
        this.sideA = a;
        this.sideB = b;
    }

    public Rectangle(double a) {
        this(a,5);
    }

    public Rectangle() {
        this(4,3);
    }

    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     */
    public double getSideA() {
        return sideA;
    }

    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     */
    public double getSideB() {
        return sideB;
    }

    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     */
    public double area() {
        return sideA*sideB;
    }

    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     */
    public double perimeter() {
        return 2*(sideA+sideB);
    }

    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     */
    public boolean isSquare() {
        return sideA == sideB;
    }

    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     */
    public void replaceSides() {
        double swap = sideA;
        sideA = sideB;
        sideB = swap;
    }

}