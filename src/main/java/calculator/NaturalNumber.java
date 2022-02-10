package calculator;

public class NaturalNumber {
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
            throw new RuntimeException();
        }
    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    public int get() {
        return number;
    }
}
