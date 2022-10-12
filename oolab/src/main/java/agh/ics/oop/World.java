package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        Direction[] directions = new Direction[args.length];
        conv(args, directions);
        run(directions);
        System.out.println("Stop");
    }

    static void conv(String[] arguments, Direction[] directions) {
        for (int i = 0; i < arguments.length; i++) {
            switch (arguments[i]){
                case "f":
                    directions[i] = Direction.FORWARD;
                    break;
                case "b":
                    directions[i] = Direction.BACKWARD;
                    break;
                case "r":
                    directions[i] = Direction.RIGHT;
                    break;
                case "l":
                    directions[i] = Direction.LEFT;
                    break;
            }
        }
    }

    static void run(Direction[] arguments){
//        System.out.println("Zwierzak idzie do przodu");
        for (Direction argument: arguments) {
            switch (argument) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
                default:
                    System.out.println("Nieznana komenda");

            }

        }
    }

}
