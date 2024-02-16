package racingcar.model;

public class TryCount {
    private int value;

    public TryCount(String input) {
        this.value = validatedInput(input);
    }

    public int validatedInput(String input) {
        try {
            int number = Integer.parseInt(input);
            isOverZero(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void isOverZero(int number) {
        if(number < 0) {
            throw new IllegalArgumentException();
        }
    }

    public void consume() {
        value--;
    }

    public boolean checkTryable() {
        return value > 0;
    }

    public int getValue() {
        return value;
    }
}
