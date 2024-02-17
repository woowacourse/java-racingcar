package racingcar.domain;

public class TrialCount {

    private final int amount;

    public TrialCount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다. : " + amount);
        }
    }

    public void repeat(Runnable runnable) {
        for (int i = 0; i < amount; i++) {
            runnable.run();
        }
    }
}
