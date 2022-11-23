package agh.ics.oop;

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
            map.animalList().get(i % map.animalList().size()).move(moves[i]);
        }
    }
}
