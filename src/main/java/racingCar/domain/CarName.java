package racingCar.domain;

public class CarName {

    private static final int NAME_MAX_LENGTH = 5;

    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String carName) {
        if (carName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
