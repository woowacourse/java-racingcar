package racingcar.model;

public class TryCount {
    private int value;

    public TryCount(String input) {
        this.value = validatedInput(input);
    }

    private int validatedInput(String input) {
        isNumericString(input);

        int number = Integer.parseInt(input);
        isOverZero(number);
        
        return number;
    }

    private void isNumericString(String input) {
        try {
            Integer.parseInt(input);
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

    int getValue() {
        return value;
    }
}
