package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveTo() {
        GrassField map = new GrassField(5);
        map.place(new Animal(map, new Vector2d(0, 1)));
        map.place(new Animal(map, new Vector2d(2, 2)));

        assertTrue(map.canMoveTo(new Vector2d(1, 2)));
        assertTrue(map.canMoveTo(new Vector2d(36, -2)));
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
    }

    @Test
    void place() {
        GrassField map = new GrassField(5);

        assertTrue(map.place(new Animal(map, new Vector2d(0, 1))));
        assertFalse(map.place(new Animal(map, new Vector2d(0, 1))));
        assertTrue(map.place(new Animal(map, new Vector2d(32, 333))));
    }

    @Test
    void isOccupied() {
        GrassField map = new GrassField(5);
        map.place(new Animal(map, new Vector2d(0, 1)));
        map.place(new Animal(map, new Vector2d(2, 2)));

        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(new Vector2d(1, 2)));
    }

    @Test
    void objectAt() {
        GrassField map = new GrassField(5);
        Animal animal = new Animal(map, new Vector2d(0, 1));
        map.place(animal);

        assertEquals(animal, map.objectAt(new Vector2d(0, 1)));
    }
}