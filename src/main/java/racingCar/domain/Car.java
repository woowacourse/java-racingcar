package racingCar.domain;

public class Car {

    private static final int MOVE_MIN_NUM  = 4;

    private String name;
    private int position;

    public Car(String carName) {
        validateLength(carName);
        this.name = carName;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move(int pickedNumber) {
        if (pickedNumber >= MOVE_MIN_NUM) {
            ++this.position;
        }
    }

    private void validateLength(String carName) {
        if (carName.length() >= 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

}
