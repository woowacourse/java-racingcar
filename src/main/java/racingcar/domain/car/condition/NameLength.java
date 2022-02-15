package racingcar.domain.car.condition;

public enum NameLength {

    ALLOWED_MAXIMUM_LENGTH(5);

    private final int length;

    NameLength(int length) {
        this.length = length;
    }

    public static boolean isTooLong(String name) {
        return name.length() > ALLOWED_MAXIMUM_LENGTH.length;
    }

    public int getLength() {
        return ALLOWED_MAXIMUM_LENGTH.length;
    }

}
