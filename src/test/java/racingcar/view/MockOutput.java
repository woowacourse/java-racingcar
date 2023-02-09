package racingcar.view;

public class MockOutput implements Output {
    private final StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void print(String message) {
        stringBuilder.append(message);
    }

    @Override
    public void println(String message) {
        stringBuilder.append(message).append('\n');
    }

    @Override
    public void println() {
        stringBuilder.append('\n');
    }

    public String output() {
        return stringBuilder.toString();
    }
}
