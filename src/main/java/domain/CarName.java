package domain;

public class CarName {

    private static final int CAR_NAME_LENGTH_LOWER_BOUND_INCLUSIVE = 1;
    private static final int CAR_NAME_LENGTH_UPPER_BOUND_INCLUSIVE = 5;

    private static final String CAR_NAME_LENGTH_ERROR = "자동차명은 1 ~ 5 글자로 입력해야합니다.";

    private final String name;

    public CarName(String name) {
        this.name = validateAndTrimCarName(name);
    }

    public String getName() {
        return this.name;
    }

    private String validateAndTrimCarName(String name) {
        name = name.trim();

        if (!(CAR_NAME_LENGTH_LOWER_BOUND_INCLUSIVE <= name.length()
                && name.length() <= CAR_NAME_LENGTH_UPPER_BOUND_INCLUSIVE)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }

        return name;
    }
}
