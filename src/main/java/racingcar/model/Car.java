package racingcar.model;

public class Car {

    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_STEP_FORWARD_STANDARD = 4;
    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public int move(int number) {
        if (number >= MINIMUM_STEP_FORWARD_STANDARD) {
            position++;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (isNameEmpty(name) || name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            String message = "자동차 이름이 1-5자 사이의 길이로 입력되지 않았습니다.";
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isNameEmpty(String name) {
        return name == null || name.isEmpty();
    }
}
