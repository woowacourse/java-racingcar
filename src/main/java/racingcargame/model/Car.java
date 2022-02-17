package racingcargame.model;

import racingcargame.dto.CarDto;

public class Car implements Comparable<Car> {
    private static final int MIN_MOVABLE_NUMBER = 4;
    private static final int MAX_NAME_LENGTH_COUNT = 5;
    private static final int MIN_NAME_LENGTH_COUNT = 1;
    private static final String EMPTY_NAME = "";
    private static final String EMPTY_NAME_ERROR_MESSAGE = "[error] 입력된 자동차 이름중 이름이 없는 자동차가 있습니다.";
    private static final String NO_VALIDATE_NAME_LENGTH_ERROR_MESSAGE = "[error] 자동차 이름을 5자 이하로 입력해주세요.";

    private final String name;
    private int position;

    public Car(final String name) {
        checkValidateName(name);
        this.name = name;
        this.position = 0;
    }

    private void checkValidateName(final String name) {
        checkNameExists(name);
        checkValidNameLength(name);
    }

    private void checkNameExists(final String name) {
        if (EMPTY_NAME.equals(name)) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }
    }

    private void checkValidNameLength(final String name) {
        if (name.length() < MIN_NAME_LENGTH_COUNT || name.length() > MAX_NAME_LENGTH_COUNT) {
            throw new IllegalArgumentException(NO_VALIDATE_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public void moveCar(final int number) {
        if (number >= MIN_MOVABLE_NUMBER) {
            position++;
        }
    }

    public boolean hasSamePosition(final Car winnerCar) {
        return this.position == winnerCar.position;
    }

    public CarDto changeToDto() {
        return new CarDto(name, position);
    }

    @Override
    public int compareTo(final Car otherCar) {
        if (this.position > otherCar.position) {
            return -1;
        } else if (this.position < otherCar.position) {
            return 1;
        }
        return 0;
    }
}

