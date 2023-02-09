package racingcar.domain;

final class CarName {
    public static final int MAX_LENGTH = 5;
    private static final String NAME_ERROR_MESSAGE = "올바른 이름을 입력해주세요.";
    private final String name;

    public CarName(String name) {
        if (name == null || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
