package agh.ics.oop;

import java.util.List;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private final RectangularMap map;

    public SimulationEngine(MoveDirection[] moves, RectangularMap map, Vector2d[] startPositions) {
        this.moves = moves;
        this.map = map;
        for (Vector2d position : startPositions) {
            map.place(new Animal(this.map, position));
        }
    }

    @Override
    public void run() {
        System.out.println(map.animals.size());
        for (int i = 0; i < moves.length; i++) {
            map.animals.get(i % map.animals.size()).move(moves[i]);
        }

    }
}
