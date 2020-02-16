package racingcar.domain;

import racingcar.utils.StringUtils;

public class CarName {
    private static final int MAX_LENGTH_OF_NAME = 5;

    private String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    String getName() {
        return name;
    }

    private static void validateName(String carName) {
        checkNull(carName);
        checkNameLength(carName);
    }

    private static void checkNameLength(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로만 입력가능합니다.");
        }
    }

    private static void checkNull(String name) {
        if (isNotValidName(name)) {
            throw new IllegalArgumentException("공백만 입력 할 수 없습니다.");
        }
    }

    private static boolean isNotValidName(String name) {
        String trimedName = StringUtils.removeAllBlank(name);
        return trimedName.isEmpty();
    }

    @Override
    public String toString() {
        return name;
    }
}
