package racingcar.view;

/*
앞 글자에 따라 뒤에 붙을 조사 이, 가 구분
유니코드는 가, 각, 갂, 갃, 간, ..., 순으로 받침 없는 글자 + 받침 있는 글자 27가지가 있다
영어는 마지막 발음을 단순 치환
*/
public class HangulPostposition {
    static final int UNICODE_START_OF_HANGUL = 0xAC00;
    static final int CYCLE = 28;
    static final char[] CONVERSION_TABLE = ("영일이삼사오육칠팔구:;<=>?@"
            + "이비씨디이프쥐치이이이엘엠엔오피큐알쓰티유이유스이지"
            + "[원]^_`이비씨디이프쥐치이이이엘엠엔오피큐알쓰티유이유스이지"
    ).toCharArray();

    public static String differentiateIGa(String sentence) {
        char letter = sentence.charAt(sentence.length() - 1);
        if ("0".charAt(0) <= letter && letter <= "z".charAt(0)) {
            letter = CONVERSION_TABLE[letter - "0".charAt(0)];
        }
        return ((letter - UNICODE_START_OF_HANGUL) % CYCLE == 0) ? "가" : "이";
    }
}