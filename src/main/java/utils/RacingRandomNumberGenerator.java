package utils;

import exception.WrongRangeMovableNumberException;

public class RacingRandomNumberGenerator implements RacingNumberGenerator{

    private static final int MIN_INCLUSIVE_VALUE = 0;
    private static final int MAX_INCLUSIVE_VALUE = 9;

    @Override
    public int generate() {
        int randomNumber = generateRandomNumber();

        validateRandomNumber(randomNumber);
        return randomNumber;
    }

    private void validateRandomNumber(int randomNumber) {
        if (isValidRangeMovableNumber(randomNumber)) {
            throw new WrongRangeMovableNumberException();
        }
    }

    private boolean isValidRangeMovableNumber(int movableValue) {
        return movableValue < MIN_INCLUSIVE_VALUE || movableValue > MAX_INCLUSIVE_VALUE;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * (MAX_INCLUSIVE_VALUE - MIN_INCLUSIVE_VALUE + 1));
    }
}
