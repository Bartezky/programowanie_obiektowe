package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        //given:
        Vector2d vector2d = new Vector2d(1, 2);

        //then:
        assertEquals("(1,2)", vector2d.toString());
    }

    @Test
    void precedes() {
        //given:
        Vector2d first = new Vector2d(1, 1);
        Vector2d second = new Vector2d(1, 2);

        //then:
        assertTrue(first.precedes(second));
    }

    @Test
    void follows() {
        //given:
        Vector2d first = new Vector2d(1, 1);
        Vector2d second = new Vector2d(1, 2);

        //then:
        assertFalse(first.follows(second));
    }

    @Test
    void upperRight() {
        //given:
        Vector2d first = new Vector2d(0, 3);
        Vector2d second = new Vector2d(2, 2);

        //then:
        assertEquals(first.upperRight(second), new Vector2d(2, 3));
    }

    @Test
    void lowerLeft() {
        //given:
        Vector2d first = new Vector2d(0, 3);
        Vector2d second = new Vector2d(2, 2);

        //then:
        assertEquals(first.lowerLeft(second), new Vector2d(0, 2));
    }

    @Test
    void add() {
        //given:
        Vector2d first = new Vector2d(0, 3);
        Vector2d second = new Vector2d(2, 2);

        //then:
        assertEquals(first.add(second), new Vector2d(2, 5));
    }

    @Test
    void subtract() {
        //given:
        Vector2d first = new Vector2d(0, 3);
        Vector2d second = new Vector2d(2, 2);

        //then:
        assertEquals(first.subtract(second), new Vector2d(-2, 1));
    }

    @Test
    void testEquals() {
        //given:
        Vector2d first = new Vector2d(0, 3);
        Vector2d second = new Vector2d(2, 2);
        Vector2d third = new Vector2d(0, 3);

        //then:
        assertNotEquals(first, second);
        assertEquals(first, third);
    }

    @Test
    void opposite() {
        //given:
        Vector2d vector2d = new Vector2d(-4, 3);

        //then:
        assertEquals(vector2d.opposite(), new Vector2d(4, -3));
    }
}