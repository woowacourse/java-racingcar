package racingcar.model;

public class TryCount {

    private int value;

    public TryCount(int value) {
        this.value = value;
    }

    public static TryCount from(final String source) {
        try {
            final int value = Integer.parseInt(source);
            if (value < 0) {
                throw new IllegalArgumentException();
            }
            return new TryCount(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
}
