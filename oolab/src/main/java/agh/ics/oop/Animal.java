package agh.ics.oop;

public class Animal {

    private MapDirection direction;
    private Vector2d location;
    private final IWorldMap map;

    public Animal(IWorldMap map) {
        direction = MapDirection.NORTH;
        location = new Vector2d(2, 2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d startPosition) {
        direction = MapDirection.NORTH;
        location = startPosition;
        this.map = map;
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
            if (map.canMoveTo(newLocation)) this.location = newLocation;
        }
    }


}
