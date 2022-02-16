package calculator.exception;

public class ElementNotExistsException extends RuntimeException {
    public ElementNotExistsException() {
        super("전달된 배열에 원소가 없습니다.");
    }
}
