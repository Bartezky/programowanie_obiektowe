package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    public final List<Animal> animals;
    protected final MapVisualiser mapVisualiser;

    protected AbstractWorldMap() {
        animals = new ArrayList<>();
        mapVisualiser = new MapVisualiser(this);
    }

    public Animal animalAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.location().equals(position))
                return animal;
        }
        return null;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }


    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.location())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public List<Animal> animals() {
        return animals;
    }

    protected abstract Vector2d[] getBorders();

    @Override
    public String toString() {
        Vector2d[] borders = getBorders();
        return mapVisualiser.draw(borders[0], borders[1]);
    }
}
