package stringcalculator.domain;

public class Input {
    private String input;
    private Delimiter delimiter;

    private Input(String input) {
        if (isNullOrBlank(input)) {
            setNullOrBlankInput();
            return;
        }

        setNormalInput(input);
    }

    private void setNullOrBlankInput() {
        this.input = "0";
        this.delimiter = DelimiterFactory.DEFAULT();
    }

    private void setNormalInput(String input) {
        this.delimiter = DelimiterFactory.valueOf(input);

        if (!delimiter.isDefault()) {
            input = extractElementString(input);
        }

        this.input = input;
    }

    public static Input valueOf(String input) {
        return new Input(input);
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isEmpty();
    }

    public Numbers getNumbers() {
        if (isNullOrBlank(input)) {
            return new Numbers(new String[]{"0"});
        }

        String[] inputs = delimiter.split(input);

        return new Numbers(inputs);
    }

    private static String extractElementString(String input) {
        return input.substring(input.indexOf("\n") + 1);
    }
}