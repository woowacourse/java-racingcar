package racingcar.domain;

public class Car {

    private static final int MOVE_RANGE = 1;
    private static final int INIT_POSITION = 0;
    private static final int BOUNDARY = 4;
    private static final int MAX_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, INIT_POSITION);
    }

    public Car(String name, int position) {
        String carName = name.trim();
        validateBlank(name);
        validateLength(carName);
        this.name = carName;
        this.position = position;
    }

    private static void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백 입력은 허용되지 않습니다.");
        }
    }

    private static void validateLength(String carName) {
        if (carName.length() >= MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 차 이름은 5글자 이하로 입력해야합니다.");
        }
    }

    public void move(int number) {
        if (number >= BOUNDARY) {
            this.position += MOVE_RANGE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
