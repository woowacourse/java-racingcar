package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        checkValidName(name);
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public static void checkValidName(final String name) {
        checkEmptyName(name);
        checkNameLength(name);
    }

    private static void checkEmptyName(final String name) {
        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException("자동차 이름은 반드시 1자 이상 존재해야 합니다.");
        }
    }

    private static void checkNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void move(int conditionValue) {
        checkValidRandomNumber(conditionValue);

        if (canMove(conditionValue)) {
            this.position++;
        }
    }

    private void checkValidRandomNumber(int conditionValue) {
        if (conditionValue < 0 || conditionValue > 9) {
            throw new IllegalArgumentException("이동 조건 값은 0 이상 9 이하인 정수여야 합니다.");
        }
    }

    private boolean canMove(int conditionValue) {
        return conditionValue >= MOVE_THRESHOLD;
    }

    public boolean isWinner(int maxDistance) {
        return this.position == maxDistance;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
