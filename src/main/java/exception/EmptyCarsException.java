package exception;

public class EmptyCarsException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "경주에 참여하는 자동차가 정상적으로 등록되지 않았습니다.";

    public EmptyCarsException() {
        super(DEFAULT_MESSAGE);
    }
}
