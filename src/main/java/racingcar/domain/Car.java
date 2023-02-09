package racingcar.domain;

import java.util.Random;
import racingcar.util.RandomIntGenerator;

public class Car {

    private static final int MINIMUM_BOUNDARY_NUMBER_DETERMINING_MOVE = 0;
    private static final int MAXIMUM_BOUNDARY_NUMBER_DETERMINING_MOVE = 9;
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private String name;
    private int movedCount;


    public Car(String name) {
        this.name = name;
        this.movedCount = 0;
    }

    public void move() {
        this.movedCount++;
    }

}
