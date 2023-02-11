package domain;

public class Car {
    private final String name;
    private int position;
    private static final String CAR_NAME_EXCEPTION_MESSAGE = "[ERROR] 자동차 이름의 길이가 1이상 4자 이하여야 합니다.";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MOVE_FORWERD_NUMBER = 4;

    public Car(String name) {
        validationCarNameLength(name);
        this.name = name;
        position = 0;
    }

    public void move(int power) {
        if (power>=MOVE_FORWERD_NUMBER) {
            this.position++;
        }
    }


    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void validationCarNameLength(String carName) throws IllegalArgumentException {
        if (carName.length() > MAX_CAR_NAME_LENGTH || carName.length() < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_EXCEPTION_MESSAGE);
        }
    }
}
