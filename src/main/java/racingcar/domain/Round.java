package racingcar.domain;

public class Round {

    private int value;

    public Round(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] 라운드가 음수일 수 없습니다.");
        }
        this.value = value;
    }

    public boolean isContinue() {
        return value > 0;
    }

    public void progress() {
        if (!isContinue()) {
            throw new IllegalStateException("[ERROR] 진행할 라운드가 없습니다.");
        }

        value--;
    }
}
