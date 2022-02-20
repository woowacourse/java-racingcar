package racingcar.exception;

public class LessThanMinimumPlayerException extends RuntimeException {

    public LessThanMinimumPlayerException(int minimumPlayerSize) {
        super("최소 참여자는 " + minimumPlayerSize + "명입니다");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
