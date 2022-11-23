package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void testCanMoveTo() {
        RectangularMap map = new RectangularMap(2, 3);
        map.place(new Animal(map, new Vector2d(0, 1)));
        map.place(new Animal(map, new Vector2d(2, 2)));

        assertTrue(map.canMoveTo(new Vector2d(1, 2)));
        assertFalse(map.canMoveTo(new Vector2d(3, 2)));
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));

    }

    @Test
    void place() {
        RectangularMap map = new RectangularMap(2, 3);

        assertTrue(map.place(new Animal(map, new Vector2d(0, 1))));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            map.place(new Animal(map, new Vector2d(3, 3)));
        });

        String expectedMessage = "can't place at (3,3)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isOccupied() {
        RectangularMap map = new RectangularMap(2, 3);
        map.place(new Animal(map, new Vector2d(0, 1)));
        map.place(new Animal(map, new Vector2d(2, 2)));

        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(new Vector2d(1, 2)));
    }

    @Test
    void objectAt() {
        RectangularMap map = new RectangularMap(2, 3);
        Animal animal = new Animal(map, new Vector2d(0, 1));
        map.place(animal);
        assertEquals(animal, map.objectAt(new Vector2d(0, 1)));
        assertNull(map.objectAt(new Vector2d(0, 0)));
    }
}