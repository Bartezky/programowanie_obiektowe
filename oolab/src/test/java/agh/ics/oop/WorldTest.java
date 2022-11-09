package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void test() {
        int mapWidth = 10;
        int mapHeight = 5;

        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(mapWidth, mapHeight);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        String expected = " y\\x  0 1 2 3 4 5 6 7 8 910\n" +
                "  6: -----------------------\n" +
                "  5: | | | |N| | | | | | | |\n" +
                "  4: | | | | | | | | | | | |\n" +
                "  3: | | | | | | | | | | | |\n" +
                "  2: | | | | | | | | | | | |\n" +
                "  1: | | | | | | | | | | | |\n" +
                "  0: | | |S| | | | | | | | |\n" +
                " -1: -----------------------\n";
        String actual = new MapVisualiser(map).draw(new Vector2d(0, 0), new Vector2d(mapWidth, mapHeight));

        assertEquals(expected, actual);
    }

}