package com.epam.test.automation.java.practice5;

import java.util.*;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */
public class ArrayRectangles{
    private List<Rectangle> rectangleArray;
    private int currentSize;

    public ArrayRectangles(int n) {
        if(n<0){
            throw new IllegalArgumentException("Cannot create array with negative size.");
        }
        rectangleArray = new ArrayList<>(n);
        currentSize = n;
    }

    public ArrayRectangles(Rectangle ...rectangles) {
        rectangleArray = new ArrayList<>(Arrays.asList(rectangles));

        currentSize = rectangleArray.size();
    }

    public int size() {
        return currentSize;
    }

    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     */
    public boolean addRectangle(Rectangle rectangle) {
        if(currentSize == rectangleArray.size()) {
            return false;
        }

        currentSize++;

        //try to replace null element
        int index = rectangleArray.indexOf(null);
        if(index!=-1){
            rectangleArray.add(index, rectangle);
        }
        else {
            rectangleArray.add(rectangle);
        }

        return true;
    }

    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     */
    public int numberMaxArea(){
        if(currentSize == 0){
            throw new IllegalArgumentException("Cannot find max element of empty array.");
        }

        Optional<Rectangle> optional = rectangleArray
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Rectangle::area));

        return optional
                .map(rectangle -> rectangleArray.indexOf(rectangle))
                .orElseThrow();
    }

    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     */
    public int numberMinPerimeter() {
        if(currentSize == 0){
            throw new IllegalArgumentException("Cannot find min perimeter element of empty array.");
        }

        Optional<Rectangle> optional = rectangleArray
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparingDouble(Rectangle::perimeter));

        return optional
                .map(rectangle -> rectangleArray.indexOf(rectangle))
                .orElseThrow();
    }

    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     */
    public int numberSquares() {
        if(currentSize == 0){
            throw new IllegalArgumentException("Cannot find number of squares in empty array.");
        }

        long count = rectangleArray
                .stream()
                .filter(rectangle-> (rectangle!=null) && rectangle.isSquare())
                .count();

        return (int)count;
    }

}
