package view.input;

public class Validator {

    private final static String ERROR_HEADER = "[ERROR] ";

    private static void throwError(ErrorMessages errorMessage) throws IllegalArgumentException {
        throw new IllegalArgumentException(ERROR_HEADER + errorMessage.getContent());
    }
}
