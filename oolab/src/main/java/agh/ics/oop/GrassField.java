package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap {

    private final Map<Vector2d, Grass> tufts;

    public GrassField(int numberOfTuft) {
        super();
        boundary = new MapBoundary(this);
        tufts = new HashMap<>();
        randomTuft(numberOfTuft);
    }

    private void randomTuft(int numberOfTuft) {
        int limit = (int) Math.sqrt(numberOfTuft * 10) + 1;
        ArrayList<Integer> randNumbers = new ArrayList<Integer>(limit * limit);
        for (int i = 0; i < limit * limit; i++)
            randNumbers.add(i);
        Collections.shuffle(randNumbers);
        for (int i = 0; i < numberOfTuft; i++) {
            Vector2d randPosition = new Vector2d(randNumbers.get(i) / (limit), randNumbers.get(i) % limit);
            tufts.put(randPosition, new Grass(randPosition));
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        Animal animal = animalAt(position);
        if (animal != null) return animal;
        else return tuftAt(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return animalAt(position) == null;
    }

    public Grass tuftAt(Vector2d position) {
        return tufts.get(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.location())) {
            animals.put(animal.location(), animal);
            animalList.add(animal);
            animal.addObserver(this);
            animal.addObserver(boundary);
            return true;
        } else throw new IllegalArgumentException("can't place at " + animal.location());
    }

}
