package racingcar.domain;

final class CarName {

    private static final int MAX_LENGTH = 5;
    private static final String NAME_ERROR_MESSAGE = "이름의 길이가 초과되었습니다";
    private static final String NAME_NULL_MESSAGE = "이름이 null입니다.";

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException(NAME_NULL_MESSAGE);
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
