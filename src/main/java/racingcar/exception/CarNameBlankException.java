package racingcar.exception;

public class CarNameBlankException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "자동차 이름은 공백이 될 수 없습니다.";

    public CarNameBlankException(String s) {
        super(s);
    }

}
