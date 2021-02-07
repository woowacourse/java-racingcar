package racingcar.domain;

public class Round {
    private final int count;

    private Round(int count) {
        this.count = count;
    }

    public static Round of(int count) {
        return new Round(count);
    }
}
