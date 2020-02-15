package application.racing.domain;

public class RandomNumber {
    private int randomNumber;

    public RandomNumber() {
        int randomValue = (int) (Math.random() * 10);
        validateRandomNumber(randomValue);
        this.randomNumber = randomValue;
    }

    private void validateRandomNumber(int randomNumber) {
        if (randomNumber < 0 || randomNumber > 9) {
            throw new IllegalArgumentException("범위를 벗어나는 값입니다.");
        }
    }

    public int getRandomNumber() {
        return this.randomNumber;
    }
}
