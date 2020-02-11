package racingcar.util;

public class InputHandler {
    public static void isNullOrEmpty(String input) {
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("빈 값 혹은 Null 입력입니다!");
        }
    }
}
