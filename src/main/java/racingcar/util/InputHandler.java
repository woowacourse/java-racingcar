package racingcar.util;

public class InputHandler {
    public static void validateNullOrEmpty(String input) {
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("빈 값 혹은 Null 입력입니다!");
        }
    }

    public static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 길이 5자 초과입니다!");
        }
    }

    public static void validateCount(int count) {
        if (count > 10) {
            throw new IllegalArgumentException("횟수 10번 초과입니다!");
        }
    }

    public static int validateNumber(String input) {
        int count = 0;
        try {
            count = Integer.parseInt(input);
        }  catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 횟수 입력");
        }
        return count;
    }
}
