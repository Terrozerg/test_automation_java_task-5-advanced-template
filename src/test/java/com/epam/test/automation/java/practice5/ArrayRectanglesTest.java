package com.epam.test.automation.java.practice5;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class ArrayRectanglesTest {
    private ArrayRectangles arrayRectangles;
    private Rectangle[] rectangles;

    @Test
    public void testVarArgConstructor(){
        rectangles = new Rectangle[]{new Rectangle(), new Rectangle(2, 3), new Rectangle(1)};
        arrayRectangles = new ArrayRectangles(rectangles);
        int size = arrayRectangles.size();

        Assert.assertEquals(rectangles.length, size);
    }

    @Test
    public void testConstructorWithSize(){
        arrayRectangles = new ArrayRectangles(5);
        int size = arrayRectangles.size();

        Assert.assertEquals(size, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
    expectedExceptionsMessageRegExp = "Cannot create array with negative size.")
    public void testConstructorWithNegativeSize(){
        arrayRectangles = new ArrayRectangles(-1);
    }

    @Test
    public void testAddRectangle(){
        arrayRectangles = new ArrayRectangles(1);
        Assert.assertTrue(arrayRectangles.addRectangle(new Rectangle()));
    }

    @Test
    public void testAddRectangleInFreePlace(){
        rectangles = new Rectangle[]{new Rectangle(), null, new Rectangle(2, 3), new Rectangle(1)};
        arrayRectangles = new ArrayRectangles(rectangles);

        Assert.assertTrue(arrayRectangles.addRectangle(new Rectangle()));
    }

    @Test
    public void testAddRectangleToFullArray(){
        arrayRectangles = new ArrayRectangles(0);
        Assert.assertFalse(arrayRectangles.addRectangle(new Rectangle()));
    }

    @Test
    public void testNumberMaxArea(){
        rectangles = new Rectangle[]{new Rectangle(), new Rectangle(2, 3), new Rectangle(1, 45)};
        arrayRectangles = new ArrayRectangles(rectangles);

        Assert.assertEquals(arrayRectangles.numberMaxArea(), 2);
    }

    @Test
    public void testNumberMaxAreaWithNullValues(){
        Rectangle[] rectangles = {new Rectangle(), null, new Rectangle(1, 45), null};
        arrayRectangles = new ArrayRectangles(rectangles);

        Assert.assertEquals(arrayRectangles.numberMaxArea(), 2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
    expectedExceptionsMessageRegExp = "Cannot find max element of empty array.")
    public void testNumberMaxAreaOfEmptyArray(){
        arrayRectangles = new ArrayRectangles(0);

        arrayRectangles.numberMaxArea();
    }

    @Test(expectedExceptions = NoSuchElementException.class,
    expectedExceptionsMessageRegExp = "No value present")
    public void testNumberMaxAreaArrayOfNulls(){
        rectangles = new Rectangle[]{null, null, null};
        arrayRectangles = new ArrayRectangles(rectangles);

        arrayRectangles.numberMaxArea();
    }

    @Test
    public void testNumberMinPerimeter(){
        rectangles = new Rectangle[]{new Rectangle(), new Rectangle(2, 3), new Rectangle(1, 45)};
        arrayRectangles = new ArrayRectangles(rectangles);

        Assert.assertEquals(arrayRectangles.numberMinPerimeter(), 1);
    }

    @Test
    public void testNumberMinPerimeterWithNullValues(){
        rectangles = new Rectangle[]{null, new Rectangle(2, 3), null, new Rectangle(1, 45)};
        arrayRectangles = new ArrayRectangles(rectangles);

        Assert.assertEquals(arrayRectangles.numberMinPerimeter(), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Cannot find min perimeter element of empty array.")
    public void testNumberMinPerimeterOfEmptyArray(){
        arrayRectangles = new ArrayRectangles(0);

        arrayRectangles.numberMinPerimeter();
    }

    @Test(expectedExceptions = NoSuchElementException.class,
            expectedExceptionsMessageRegExp = "No value present")
    public void testNumberMinPerimeterArrayOfNulls(){
        rectangles = new Rectangle[]{null, null, null};
        arrayRectangles = new ArrayRectangles(rectangles);

        arrayRectangles.numberMinPerimeter();
    }

    @Test
    public void testNumberSquares(){
        rectangles = new Rectangle[]{new Rectangle(), new Rectangle(3, 3), new Rectangle(45, 45)};
        arrayRectangles = new ArrayRectangles(rectangles);

        Assert.assertEquals(arrayRectangles.numberSquares(), 2);
    }

    @Test
    public void testNumberSquaresWithNullValues(){
        rectangles = new Rectangle[]{null, new Rectangle(2, 3), null, new Rectangle(10, 10)};
        arrayRectangles = new ArrayRectangles(rectangles);

        Assert.assertEquals(arrayRectangles.numberSquares(), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Cannot find number of squares in empty array.")
    public void testNumberSquaresOfEmptyArray(){
        arrayRectangles = new ArrayRectangles(0);

        arrayRectangles.numberSquares();
    }

    @Test
    public void testNumberSquaresArrayOfNulls(){
        rectangles = new Rectangle[]{null, null, null};
        arrayRectangles = new ArrayRectangles(rectangles);

        Assert.assertEquals(arrayRectangles.numberSquares(),0);
    }
}