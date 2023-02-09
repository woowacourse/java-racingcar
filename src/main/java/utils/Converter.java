package utils;

public class Converter {
    public static Long convertStringToLong(String target) {
        try {
            return Long.parseLong(target);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
