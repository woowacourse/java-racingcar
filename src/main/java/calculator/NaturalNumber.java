package calculator;

public class NaturalNumber {
    private static final String NOT_NUMBER_ERROR = "입력값은 숫자여야 합니다.";
    private static final String NEGATIVE_NUMBER_ERROR = "입력값은 자연수여야 합니다.";

    private final int number;

    public NaturalNumber(String value) {
        validateNumberFormat(value);
        int number = Integer.parseInt(value);
        validateNegative(number);
        this.number = number;
    }

    private void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NOT_NUMBER_ERROR);
        }
    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_ERROR);
        }
    }

    public int get() {
        return number;
    }
}
