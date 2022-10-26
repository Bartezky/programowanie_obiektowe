package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void mainTestForDirection() {
        //given:
        String[] args = {"right", "right", "l"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] moveDirections = parser.parse(args);
        Animal cat = new Animal();
        for (MoveDirection moveDirection : moveDirections) {
            cat.move(moveDirection);
        }

        assertEquals("orientacja = wschód, pozycja = (2,2)", cat.toString());
    }

    @Test
    void mainTestForMoving() {
        //given:
        String[] args = {"f", "forward", "right", "b", "backward", "left", "b"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] moveDirections = parser.parse(args);
        Animal cat = new Animal();
        for (MoveDirection moveDirection : moveDirections) {
            cat.move(moveDirection);
        }

        assertEquals("orientacja = północ, pozycja = (0,3)", cat.toString());
    }


    @Test
    void mainTestMapLimits() {
        //given:
        String[] args = {"b", "backward", "b", "b", "backward", "left", "f", "forward", "f", "f", "b"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] moveDirections = parser.parse(args);
        Animal cat = new Animal();
        for (MoveDirection moveDirection : moveDirections) {
            cat.move(moveDirection);
        }

        assertEquals("orientacja = zachód, pozycja = (1,0)", cat.toString());
    }

    @Test
    void mainTestForInvalidInput() {
        //given:
        String[] args = {"b", "x", "b", "bbb", "left", "rz", "f", "ąśź", "v", "123", "b"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] moveDirections = parser.parse(args);
        Animal cat = new Animal();
        for (MoveDirection moveDirection : moveDirections) {
            cat.move(moveDirection);
        }

        assertEquals("orientacja = zachód, pozycja = (2,0)", cat.toString());
    }


}