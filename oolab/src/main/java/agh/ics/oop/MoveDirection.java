package agh.ics.oop;

public enum MoveDirection {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT;

    public String toString() {
        return switch (this) {
            case FORWARD -> "Ruch = przód";
            case BACKWARD -> "Ruch = tył";
            case RIGHT -> "Ruch = prawo";
            case LEFT -> "Ruch = lewo";
        };
    }
}


