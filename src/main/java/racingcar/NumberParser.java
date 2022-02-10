package racingcar;

public class NumberParser {

    public int parse(String input) {
        if (input.matches("(-|\\+)?[0-9]+\\.[0-9]+")) {
            throw new IllegalArgumentException("시도 횟수는 실수가 될 수 없습니다.");
        }
        int tryCount = Integer.parseInt(input);
        if (tryCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.");
        }
        return tryCount;
    }
}
