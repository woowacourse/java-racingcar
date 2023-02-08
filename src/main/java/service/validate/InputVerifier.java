package service.validate;

import exception.ErrorMessage;

public class InputVerifier {

    public static String[] splitInput(String input) {
        String[] names = input.split(",");
        validateNameLength(names);
        return names;
    }

    private static void validateNameLength(String[] names) {
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

}
