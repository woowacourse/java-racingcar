package racingcar.domain;

import java.util.Random;
import racingcar.dto.CarDto;
import racingcar.util.RandomIntGenerator;

public class Car {

    private static final int MINIMUM_BOUNDARY_NUMBER_DETERMINING_MOVE = 0;
    private static final int MAXIMUM_BOUNDARY_NUMBER_DETERMINING_MOVE = 9;
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String WRONG_LENGTH_OF_NAME_ANNOUNCEMENT = "[ERROR] 잘못된 이름 길이입니다.";

    private String name;
    private int movedCount;


    public Car(String name) {
        validateName(name);
        this.name = name;
        this.movedCount = 0;
    }

    public void move() {
        this.movedCount++;
    }

    public CarDto getStatus() {
        return new CarDto(this.name, this.movedCount);
    }

    private void validateName(String name) {
        if (MINIMUM_NAME_LENGTH <= name.length() && name.length() <= MAXIMUM_NAME_LENGTH) {
            return;
        }
        throw new IllegalArgumentException(WRONG_LENGTH_OF_NAME_ANNOUNCEMENT);
    }

}
