package racingcar.DTO;

import java.util.Random;

public class Car {
    private final static int RANDOM_NUMBER_OFFSET = 10;
    private String name;
    private int position;

    Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void Move() {

    }

    private int GenerateRandomNumber() {
        return new Random().nextInt(10);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


}
