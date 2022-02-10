package racingcar;

import java.util.regex.Pattern;

public class StringParser {

    // 테스트를 위한 고정 입력
    public static String readNameFixedInput(String fixedInput){
        return fixedInput;
    }

    public static void validateCarName(String input) {
        // \w 문자이거나 숫자이거나 언더바이거나

        if (input.matches(".*[^0-9a-zA-Zㄱ-ㅎ가-힣_]+.*")) {
            throw new RuntimeException("올바르지 않은 입력 형식입니다.");
        }
    }
}
