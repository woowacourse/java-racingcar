package racingcar.exception;

public class NoCarsToFindMaxDistanceException extends RuntimeException {
    private static final String MESSAGE = "차량이 없어 최대 이동 거리를 찾을 수 없습니다.";

    public NoCarsToFindMaxDistanceException() {
        super(MESSAGE);
    }
}
