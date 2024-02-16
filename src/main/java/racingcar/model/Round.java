package racingcar.model;

public class Round {

    private int value;

    private Round(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] 라운드가 음수일 수 없습니다.");
        }
        this.value = value;
    }

    public static Round from(final String source) {
        final int value = parseInt(source);
        return new Round(value);
    }

    private static int parseInt(final String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 라운드는 숫자로 입력바랍니다.");
        }
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
