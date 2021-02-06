package calculator;

public class Number {

    public static final int NUMBER_ZERO = 0;

    private final int number;

    public Number(final String number) {
        this.number = validateNumber(number);
    }

    private int validateNumber(final String number) {
        if (number == null || number.isEmpty()) {
            return NUMBER_ZERO;
        }

        try {
            return validatePositiveNumber(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private int validatePositiveNumber(final String number) {
        int result = Integer.parseInt(number);
        if (result < NUMBER_ZERO) {
            throw new RuntimeException();
        }
        return result;
    }

    public int getNumber() {
        return number;
    }

}
