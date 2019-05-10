package racingcar.utils;

public class StringUtils {
    /*
    앞 글자에 따라 조사 이, 가 구분
    */
    public static String differentiateIGa(final char letter) {
        final char[] CONVERSION_TABLE = ("영일이삼사오육칠팔구:;<=>?@"
                + "이비씨디이프쥐치이이이엘엠엔오피큐알쓰티유이유스이지"
                + "[원]^_`이비씨디이프쥐치이이이엘엠엔오피큐알쓰티유이유스이지"
        ).toCharArray();
        if (48 <= letter && letter <= 122) {
            return ((CONVERSION_TABLE[letter - 48] - 0xAC00) % 28 == 0) ? "가" : "이";
        }

        return ((letter - 0xAC00) % 28 == 0) ? "가" : "이";
    }
}
