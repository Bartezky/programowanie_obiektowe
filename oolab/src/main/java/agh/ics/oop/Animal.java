package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class Animal {

    private final IWorldMap map;
    private MapDirection direction;
    private Vector2d location;
    private final List<IPositionChangeObserver> observers;


    public Animal(IWorldMap map, Vector2d startPosition) {
        direction = MapDirection.NORTH;
        location = startPosition;
        this.map = map;
        observers = new LinkedList<>();
    }

    public Vector2d location() {
        return location;
    }

    @Override
    public String toString() {
        switch (this.direction) {
            case NORTH -> {
                return "N";
            }
            case EAST -> {
                return "E";
            }
            case WEST -> {
                return "W";
            }
            case SOUTH -> {
                return "S";
            }
        }
        return null;
    }

    public boolean isAt(Vector2d position) {
        return location.equals(position);
    }

    public void move(MoveDirection direction) {
        Vector2d newLocation = null;
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> newLocation = this.location.add(this.direction.toUnitVector());
            case BACKWARD -> newLocation = this.location.subtract(this.direction.toUnitVector());
        }
        if (newLocation != null) {
            if (map.canMoveTo(newLocation)) {
                Vector2d oldLocation = new Vector2d(this.location.x(), this.location.y());
                this.location = newLocation;
                positionChanged(oldLocation, newLocation);
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

}
