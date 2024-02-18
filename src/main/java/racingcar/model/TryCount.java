package racingcar.model;

public final class TryCount {
    private static final int END_LINE = 0;

    private final int value;

    public TryCount(String input) {
        this.value = validatedInput(input);
    }

    public int validatedInput(String input) {
        try {
            int number = Integer.parseInt(input);
            checkIfUnderEndLine(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIfUnderEndLine(int number) {
        if (number < END_LINE) {
            throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return value;
    }
}
