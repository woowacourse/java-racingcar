package validation;

public abstract class Validator<T> {

    private static String ERROR_HEADER = "[ERROR] ";

    protected static void throwError(String errorMessage) {
        throw new IllegalArgumentException(ERROR_HEADER + errorMessage);
    }

    abstract void validate(T param);
}
