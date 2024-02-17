package exception;

public class MaxCarNameLengthException extends RuntimeException {
    private static final String TOO_LONG_CAR_NAME_EXCEPTION = "[ERROR] 자동차 이름이 너무 깁니다.\n";

    public MaxCarNameLengthException(final String name, final int maxLength) {
        super(TOO_LONG_CAR_NAME_EXCEPTION
                + "invalid name: " + name
                + "\nname length: " + name.length()
                + "\nmax length: " + maxLength);
    }
}
