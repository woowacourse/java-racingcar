package stringcalculator;

public class InputStringDTO {

    private static final String BLANK = "";
    private static final String DEFAULT = "0";

    private final String input;

    public InputStringDTO(String input) {
        if (isEmpty(input)) {
            this.input = DEFAULT;
            return;
        }
        this.input = input;
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().equals(BLANK);
    }

    public String getInput() {
        return input;
    }

}
