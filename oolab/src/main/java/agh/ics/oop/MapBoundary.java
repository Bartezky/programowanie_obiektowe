package agh.ics.oop;

public class MapBoundary implements IPositionChangeObserver {

    AbstractWorldMap map;
    Boolean set = false;
    private int minX, maxX, minY, maxY;

    public MapBoundary(AbstractWorldMap map) {
        this.map = map;
        minX = 0;
        maxX = 0;
        minY = 0;
        maxY = 0;
    }

    public MapBoundary(AbstractWorldMap map, int minX, int maxX, int minY, int maxY) {
        this.map = map;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public Vector2d lowerLeft() {
        return new Vector2d(minX, minY);
    }

    public Vector2d upperRight() {
        return new Vector2d(maxX, maxY);
    }

    private void setBoundary() {
        set = true;
        setMinX();
        setMaxX();
        setMinY();
        setMaxY();
    }

    private void setMinX() {
        int left = Integer.MAX_VALUE;
        for (Animal animal : map.animals.values()) {
            Vector2d location = animal.location();
            left = Math.min(left, location.x());
        }
        minX = left;
    }

    private void setMaxX() {
        int right = Integer.MIN_VALUE;
        for (Animal animal : map.animals.values()) {
            Vector2d location = animal.location();
            right = Math.max(right, location.x());
        }
        maxX = right;
    }

    private void setMinY() {
        int low = Integer.MAX_VALUE;
        for (Animal animal : map.animals.values()) {
            Vector2d location = animal.location();
            low = Math.min(low, location.y());
        }
        minY = low;
    }

    private void setMaxY() {
        int up = Integer.MIN_VALUE;
        for (Animal animal : map.animals.values()) {
            Vector2d location = animal.location();
            up = Math.max(up, location.y());
        }
        maxY = up;
    }


    private void updateBoundary(Vector2d oldPosition, Vector2d newPosition) {
        if (!set) setBoundary();
        if (oldPosition.x() == minX) {
            if (newPosition.x() < minX) minX = newPosition.x();
            else setMinX();
        }
        if (oldPosition.x() == maxX) {
            if (newPosition.x() > maxX) maxX = newPosition.x();
            else setMaxX();
        }
        if (oldPosition.y() == minY) {
            if (newPosition.y() < minY) minY = newPosition.y();
            else setMinY();
        }
        if (oldPosition.y() == maxY) {
            if (newPosition.y() > maxY) maxY = newPosition.y();
            else setMaxY();
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        updateBoundary(oldPosition, newPosition);
    }
}
