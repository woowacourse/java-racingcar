package racing.validate;

import racing.view.output.OutputView;

public class InputVerifier {

    public static void validateNameLength(String[] names) {
        for (String name : names) {
            checkNameLength(name);
            checkSpace(name);
        }
    }

    private static void checkSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(OutputView.CANT_CONTAIN_SPACE);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() < 1 || 5 < name.length()) {
            throw new IllegalArgumentException(OutputView.UNSUITABLE_LENGTH);
        }
    }

    public static void checkInputTypeIsNumber(String input) {
        final String REGEX = "[0-9]+";
        if(!input.matches(REGEX)){
            throw new IllegalArgumentException(OutputView.INPUT_ONLY_DIGIT);
        }
    }
}
