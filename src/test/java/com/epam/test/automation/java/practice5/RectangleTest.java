package com.epam.test.automation.java.practice5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTest {
    private Rectangle rectangle;

    @Test
    public void testConstructorWithTwoValues(){
        rectangle = new Rectangle(1.5,2.9);
        Assert.assertEquals(rectangle.getSideA(),1.5);
        Assert.assertEquals(rectangle.getSideB(),2.9);
    }

    @Test
    public void testConstructorWithOneValue(){
        rectangle = new Rectangle(1.5);
        Assert.assertEquals(rectangle.getSideA(),1.5);
        Assert.assertEquals(rectangle.getSideB(),5);
    }

    @Test
    public void testDefaultConstructor(){
        rectangle = new Rectangle();
        Assert.assertEquals(rectangle.getSideA(),4);
        Assert.assertEquals(rectangle.getSideB(),3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Cannot create rectangle with negative sides.")
    public void testConstructorWithNegativeValues(){
        rectangle = new Rectangle(-5.2,-9);
    }

    @Test
    public void testArea(){
        rectangle = new Rectangle(5.6,7.1);
        Assert.assertEquals(rectangle.area(), 39.76);
    }

    @Test
    public void testAreaBorders(){
        rectangle = new Rectangle(Double.MAX_VALUE,2);
        Assert.assertEquals(rectangle.area(), Double.POSITIVE_INFINITY);
    }

    @Test
    public void testPerimeter(){
        rectangle = new Rectangle(5.6,7.1);
        Assert.assertEquals(rectangle.perimeter(), 25.4);
    }

    @Test
    public void testPerimeterBorders(){
        rectangle = new Rectangle(5.6,Double.MAX_VALUE);
        Assert.assertEquals(rectangle.perimeter(), Double.POSITIVE_INFINITY);
    }

    @Test
    public void testSquareFalse(){
        rectangle = new Rectangle(5.6,7.1);
        Assert.assertFalse(rectangle.isSquare());
    }

    @Test
    public void testSquareTrue(){
        rectangle = new Rectangle(7.1,7.1);
        Assert.assertTrue(rectangle.isSquare());
    }

    @Test
    public void testReplaceSides(){
        rectangle = new Rectangle(5.6,7.1);
        rectangle.replaceSides();
        Assert.assertEquals(rectangle.getSideB(), 5.6);
        Assert.assertEquals(rectangle.getSideA(), 7.1);
    }
}