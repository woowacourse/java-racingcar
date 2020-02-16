package application.racing.domain;

public class RandomNumber {
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;

    private int randomNumber;

    public RandomNumber() {
        int randomValue = (int) (Math.random() * 10);
        validateRandomNumber(randomValue);
        this.randomNumber = randomValue;
    }

    private void validateRandomNumber(int randomNumber) {
        if (randomNumber < MINIMUM_RANDOM_NUMBER || randomNumber > MAXIMUM_RANDOM_NUMBER) {
            throw new IllegalArgumentException("범위를 벗어나는 값입니다.");
        }
    }

    public int getRandomNumber() {
        return this.randomNumber;
    }
}
