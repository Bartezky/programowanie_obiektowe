package agh.ics.oop;

public class Animal {

    private MapDirection direction;
    private Vector2d location;

    public Animal() {
        direction = MapDirection.NORTH;
        location = new Vector2d(2, 2);
    }

    @Override
    public String toString() {
        return "orientacja = " + direction + ", pozycja = " + location;
    }

    public boolean isAt(Vector2d position) {
        return location.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> this.location = this.location.add(this.direction.toUnitVector());
            case BACKWARD -> this.location = this.location.subtract(this.direction.toUnitVector());
        }
        this.location = this.location.lowerLeft(new Vector2d(4, 4));
        this.location = this.location.upperRight(new Vector2d(0, 0));
    }


}
