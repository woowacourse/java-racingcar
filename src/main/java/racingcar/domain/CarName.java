package racingcar.domain;

import racingcar.constant.ErrorConstant;

public class CarName {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(final String input) {
        String name = removeBlank(input);
        if (name.length() > MAXIMUM_NAME_LENGTH || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    private String removeBlank(String input) {
        return input.trim();
    }
}
