package stringcalculator;

public class InputStringDTO {

    private static final String DEFAULT = "0";

    private final String input;

    public InputStringDTO(String input) {
        this.input = validate(input);
    }

    private String validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return DEFAULT;
        }
        return input;
    }

    public String getInput() {
        return input;
    }
}
