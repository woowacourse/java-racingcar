package racingcar;

public class RacingCar {

    private String name;

    public RacingCar(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }
}
