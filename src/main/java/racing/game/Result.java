package racing.game;

public class Result {
    private final StringBuilder stringBuilder;
    private final String NEW_LINE = "\n";

    public Result() {
        stringBuilder = new StringBuilder();
    }

    public void add(String toString) {
        stringBuilder.append(toString + NEW_LINE);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
