package racingcar.model;

import java.util.Random;

public class Car {
    private int position;
    private String name;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
