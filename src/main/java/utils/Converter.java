package utils;

import utils.constants.ErrorMessages;

public class Converter {
    private Converter() {
    }

    public static Long convertStringToLong(String target) {
        try {
            return Long.parseLong(target);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_FORMAT.getMessage());
        }
    }
}
