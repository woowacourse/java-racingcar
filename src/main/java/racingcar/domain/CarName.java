package racingcar.domain;

public class CarName {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateCarName(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 null 일 수 없습니다.");
        }

        validateCarNameLength(carName);
        validateCarNameSpace(carName);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상이어야 합니다.");
        }

        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하이어야 합니다.");
        }
    }

    private void validateCarNameSpace(String carName) {
        if (carName.contains(" ")){
            throw new IllegalArgumentException("[ERROR] 공백 없이 입력해주세요.");
        }
    }
}
