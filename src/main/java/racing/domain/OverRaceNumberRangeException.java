package racing.domain;

public class OverRaceNumberRangeException extends RuntimeException {
    public OverRaceNumberRangeException() {
        super("1~9까지 숫자만 가능합니다.");
    }
}
