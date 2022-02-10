package racingcar;

public class RacingCar {

    private static final int NAME_MAX_LENGTH = 5;

    private String name;

    public RacingCar(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }
}
