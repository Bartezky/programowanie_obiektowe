package agh.ics.oop;

import java.util.List;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private final IWorldMap map;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startPositions) {
        this.moves = moves;
        this.map = map;
        for (Vector2d position : startPositions) {
            map.place(new Animal(this.map, position));
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < moves.length; i++) {
            map.animals().get(i % map.animals().size()).move(moves[i]);
        }

    }
}
