package agh.ics.oop;

public class World {
    public static void main(String[] args) {

        Animal animal = new Animal();
        System.out.println(animal);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        System.out.println(animal);
        System.out.println("---------");

        Animal cat = new Animal();
        System.out.println(cat);
        OptionsParser parser = new OptionsParser();
        MoveDirection[] moveDirections = parser.parse(args);
        for (MoveDirection moveDirection : moveDirections) {
            cat.move(moveDirection);
            System.out.println(moveDirection + ", " + cat);
        }
    }


}
