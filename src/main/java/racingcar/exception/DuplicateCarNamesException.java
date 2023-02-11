package racingcar.exception;

public class DuplicateCarNamesException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 중복된 차 이름이 존재합니다.";

    public DuplicateCarNamesException() {
        super(ERROR_MESSAGE);
    }
}
