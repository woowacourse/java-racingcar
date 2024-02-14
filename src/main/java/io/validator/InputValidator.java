package io.validator;

public class InputValidator {

    public static void validateIntFormat(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
}
