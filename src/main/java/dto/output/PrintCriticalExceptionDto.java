package dto.output;

public final class PrintCriticalExceptionDto {
    private final Exception exception;

    public PrintCriticalExceptionDto(final Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }
}
