package domain;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_EXCEED = "[ERROR] 자동차 이름의 길이가 5글자를 넘습니다.";

    private final String carName;
    private int position;

    public Car(final String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
        position = 0;
    }

    public Car(final Car car) {
        carName = car.getCarName();
        position = car.getPosition();
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEED);
        }
    }
}
