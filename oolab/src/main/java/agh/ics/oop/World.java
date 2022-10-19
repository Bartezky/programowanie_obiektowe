package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");

        Direction[] directions = conv(args);
        run(directions);
        System.out.println("Stop");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));


    }

    static Direction[] conv(String[] arguments) {
        Direction[] directions = new Direction[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            switch (arguments[i]) {
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "r" -> directions[i] = Direction.RIGHT;
                case "l" -> directions[i] = Direction.LEFT;
            }
        }
        return directions;
    }

    static void run(Direction[] arguments){
        for (Direction argument: arguments) {
            switch (argument) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
                default -> System.out.println("Nieznana komenda");
            }

        }
    }

}
