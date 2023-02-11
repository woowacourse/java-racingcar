package utils;

public class Converter {

    public static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다.";

    public static Long convertStringToLong(String target) {
       try {
           return Long.parseLong(target);
       } catch(NumberFormatException exception) {
           throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
       }
    }
}
