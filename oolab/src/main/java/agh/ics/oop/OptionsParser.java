package agh.ics.oop;

public class OptionsParser {

    public MoveDirection[] parse(String[] strings) {
        int counter = 0;
        for (String s : strings) {
            if (s.equals("f") || s.equals("forward") ||
                    s.equals("r") || s.equals("right") ||
                    s.equals("b") || s.equals("backward") ||
                    s.equals("l") || s.equals("left")) counter++;
            else throw new IllegalArgumentException(s + " is not legal move specification");
        }
        MoveDirection[] moveDirections = new MoveDirection[counter];
        int i = 0;
        for (String s : strings) {
            switch (s) {
                case "f", "forward" -> moveDirections[i++] = MoveDirection.FORWARD;
                case "r", "right" -> moveDirections[i++] = MoveDirection.RIGHT;
                case "b", "backward" -> moveDirections[i++] = MoveDirection.BACKWARD;
                case "l", "left" -> moveDirections[i++] = MoveDirection.LEFT;
            }
        }
        return moveDirections;
    }

}
