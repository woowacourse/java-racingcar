package exception;

public abstract class RuntimeExceptionImpl extends RuntimeException {

    private static final String ERROR_TAG = "[ERROR] ";

    public RuntimeExceptionImpl(String message) {
        super(makeDefaultErrorMessage(message));
    }

    private static String makeDefaultErrorMessage(final String message) {
        return ERROR_TAG + message;
    }
}
