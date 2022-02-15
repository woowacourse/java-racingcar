package racingcar.domain.car.condition;

public class NameLength {

    public static final int ALLOWED_MAXIMUM_LENGTH = 5;

    private NameLength() {
    }

    public static boolean isTooLong(String name) {
        return name.length() > ALLOWED_MAXIMUM_LENGTH;
    }

}
