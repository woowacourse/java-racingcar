package racingcar.exception;

public class InvalidCarNameLengthException extends RuntimeException {

    public InvalidCarNameLengthException(int minLength, int maxLength) {
        super("[ERROR] 경주 참가자의 이름의 길이는"
                + minLength + "자 이상 "
                + maxLength + "자 이하여야 합니다.");
    }
}
