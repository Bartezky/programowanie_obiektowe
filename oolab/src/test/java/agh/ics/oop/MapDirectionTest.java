package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void next() {
        //when:
        MapDirection north = MapDirection.NORTH;
        MapDirection east = MapDirection.EAST;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;

        //then:
        assertEquals(MapDirection.EAST, north.next());
        assertEquals(MapDirection.SOUTH, east.next());
        assertEquals(MapDirection.WEST, south.next());
        assertEquals(MapDirection.NORTH, west.next());
    }

    @Test
    void previous() {
        //when:
        MapDirection north = MapDirection.NORTH;
        MapDirection east = MapDirection.EAST;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;

        //then:
        assertEquals(MapDirection.WEST, north.previous());
        assertEquals(MapDirection.NORTH, east.previous());
        assertEquals(MapDirection.EAST, south.previous());
        assertEquals(MapDirection.SOUTH, west.previous());
    }
}