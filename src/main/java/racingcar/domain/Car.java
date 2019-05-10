package racingcar.domain;

public class Car {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (isOverFiveCharacters(name)) {
            throw new IllegalArgumentException(LIMIT_CAR_NAME_LENGTH + "자 이하의 자동차 이름만 허용됩니다.");
        }
        this.name = name;
        this.position = position;
    }

    private boolean isOverFiveCharacters(String carName) {
        return carName.length() > LIMIT_CAR_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }

    public boolean isFartherPosition(int position) {
        return this.position > position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        String output = name + " : ";

        for (int i = 0; i < position; i++) {
            output += "-";
        }
        return output;
    }
}
