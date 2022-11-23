package agh.ics.oop;

public class World {
    public static void main(String[] args) {

        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new RectangularMap(5, 5);
            Vector2d[] positions = {new Vector2d(6, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
