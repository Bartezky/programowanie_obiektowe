package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {

    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        super();
        boundary = new MapBoundary(this, 0, height, 0, width);
        this.width = width;
        this.height = height;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animalAt(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.x() < 0 || position.x() > width || position.y() < 0 || position.y() > height) return false;
        return animalAt(position) == null;
    }

}
