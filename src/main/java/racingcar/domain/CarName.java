package racingcar.domain;

final class CarName {
    public static final int MAX_LENGTH = 5;
    private static final String NAME_ERROR_MESSAGE = "[ERROR] 5자 이하의 이름을 입력해주세요.";
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
