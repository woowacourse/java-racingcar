package racingcar.util;

public class ValidatorUtils {

    public static void validatePositiveInt(int integer) {
        if (integer <= 0){
            throw new RuntimeException("양수를 입력해야 합니다.");
        }
    }
}
