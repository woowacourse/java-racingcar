package service.validate;

import exception.ErrorMessage;

public class InputVerifier {

    public static void validateNameLength(String[] names) {
        for (String name : names) {
            checkNameLength(name);
            checkSpace(name);
        }
    }

    private static void checkSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.CANT_CONTAIN_SPACE.getMessage());
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() < 1 || 5 < name.length()) {
            throw new IllegalArgumentException(ErrorMessage.UNSUITABLE_LENGTH.getMessage());
        }
    }


    public static void checkInputTypeIsNumber(String input) {
        final String REGEX = "[0-9]+";
        if(!input.matches(REGEX)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_ONLY_DIGIT.getMessage());
        }
    }
}
