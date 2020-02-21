package racingcargame.domain;

public class Repeat {
    private final int number;

    public Repeat(String userInputNumber) {
        validateFormat(userInputNumber);
        int number = Integer.parseInt(userInputNumber);
        validateLength(number);
        this.number = number;
    }

    private void validateFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자로 입력해주세요.");
        }
    }

    private void validateLength(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 양수여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
