package racingcar.model;

public class Round {

    private int value;

    public Round(int value) {
        this.value = value;
    }

    public static Round from(final String source) {
        try {
            final int value = Integer.parseInt(source);
            if (value < 0) {
                throw new IllegalArgumentException();
            }
            return new Round(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEnd() {
        return value == 0;
    }

    // TODO: 괜찮은 이름 찾기
    public void progress() {
        if (isEnd()) {
            throw new IllegalStateException();
        }
        value--;
    }
}
