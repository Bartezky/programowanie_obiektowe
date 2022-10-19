package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        return switch (this) {
            case NORTH -> "północ";
            case SOUTH -> "południe";
            case WEST -> "zachód";
            case EAST -> "wschód";
        };
    }

    public MapDirection next(){
        return switch (this) {
            case NORTH -> MapDirection.EAST;
            case EAST -> MapDirection.SOUTH;
            case SOUTH -> MapDirection.WEST;
            case WEST -> MapDirection.NORTH;
        };
    }

    public MapDirection previous(){
        return switch (this) {
            case NORTH -> MapDirection.WEST;
            case WEST -> MapDirection.SOUTH;
            case SOUTH -> MapDirection.EAST;
            case EAST -> MapDirection.NORTH;
        };
    }

    public Vector2d toUnitVector(){
        switch (this) {
            case NORTH -> {
                return new Vector2d(0, 1);
            }
            case EAST -> {
                return new Vector2d(1, 0);
            }
            case SOUTH -> {
                return new Vector2d(0, -1);
            }
            case WEST -> {
                return new Vector2d(-1, 0);
            }
        }
        return null;
    }



}


