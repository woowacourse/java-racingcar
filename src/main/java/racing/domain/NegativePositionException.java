package racing.domain;

public class NegativePositionException extends RuntimeException {
    public NegativePositionException() {
        super("포지션은 음수가 될 수 없습니다.");
    }
}
