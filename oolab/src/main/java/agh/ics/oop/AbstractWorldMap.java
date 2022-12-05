package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected final List<Animal> animalList;
    protected final Map<Vector2d, Animal> animals;
    protected final MapVisualiser mapVisualiser;
    protected MapBoundary boundary;

    protected AbstractWorldMap() {
        animals = new HashMap<>();
        mapVisualiser = new MapVisualiser(this);
        animalList = new ArrayList<>();
    }

    public Animal animalAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }


    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.location())) {
            animals.put(animal.location(), animal);
            animalList.add(animal);
            animal.addObserver(this);
            return true;
        } else throw new IllegalArgumentException("can't place at " + animal.location());
    }


    public Vector2d[] getBorders() {
        return new Vector2d[]{boundary.lowerLeft(), boundary.upperRight()};
    }

    @Override
    public String toString() {
        Vector2d[] borders = getBorders();
        return mapVisualiser.draw(borders[0], borders[1]);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal changedAnimal = animals.remove(oldPosition);
        animals.put(newPosition, changedAnimal);
    }

    public List<Animal> animalList() {
        return animalList;
    }

}
