package racingCar.domain;

public class CarName {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_DELIMITER = ",";

    private String name;

    public CarName(String name) {
        validateLength(name);
        validateNames(name);
        this.name = name;
    }

    private void validateLength(String carName) {
        if (carName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

    }

    private void validateNames(String carName) {
        String[] carNames = carName.split(NAME_DELIMITER);
        if (isBlank(carNames)) {
            throw new IllegalArgumentException("자동차는 1개 이상 입력해주세요.");
        }
    }

    private boolean isBlank(String[] carNames) {
        return carNames.length == 0;
    }


    public String getName() {
        return name;
    }
}
