package racingcar.domain;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        carName = carName.trim();
        validateBlank(carName);
        validateLength(carName);
        this.carName = carName;
    }

    private static void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백 입력은 허용되지 않습니다.");
        }
    }

    private static void validateLength(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 차 이름은 5글자 이하로 입력해야합니다.");
        }
    }

    public String getCarName() {
        return carName;
    }
}
