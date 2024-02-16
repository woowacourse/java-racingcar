package racingcar.model;

public class CarName {

    private static final int MIN_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 값일 수 없습니다.");
        }

        if (name.trim().length() > MIN_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 " + MIN_LENGTH + "이하만 가능 합니다.");
        }
    }

    public String getName() {
        return name;
    }


}
