package util;

public class Validation {
    public static void isAlpha(char ch){
        if (ch < 'A' || ch > 'Z') {
            throw new IllegalArgumentException("차 이름 영문 이외의 값 오류");
        }
    }
}
