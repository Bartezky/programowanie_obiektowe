package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    private final int width;
    private final int height;
    public final List<Animal> animals;
    private final MapVisualiser mapVisualiser;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        animals = new ArrayList<>();
        mapVisualiser = new MapVisualiser(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.x < 0 || position.x > width || position.y < 0 || position.y > height)
            return false;
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.location)) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.location.equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.location.equals(position))
                return animal;
        }
        return null;
    }

    @Override
    public String toString() {
        return mapVisualiser.draw(new Vector2d(0, 0), new Vector2d(width, height));
    }
}
