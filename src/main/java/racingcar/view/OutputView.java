package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void printRounds(List<String> names, List<Integer> positions) {
        System.out.println("실행 결과");
        for (int i = 0; i < positions.size();) {
            for (int j = 0; j < names.size(); i++, j++) {
                System.out.println(names.get(j) + " : " + drawTrail(positions.get(i)));
            }
            System.out.println();
        }
    }

    private static String drawTrail(int length) {
        StringBuffer trail = new StringBuffer();

        for (int i = 0; i < length; i++) {
            trail.append("-");
        }
        return trail.toString();
    }

    public static void printWinners(List<Car> winners) {
        String winnerList = winners.toString();
        System.out.println(
                winnerList.substring(1, winnerList.length() - 1)
                + differentiateIGa(winnerList.charAt(winnerList.length() - 2))
                + " 최종 우승했습니다."
        );

    }

    /*
    유니코드 표상에서 앞 글자의 받침 여부를 판단해 이/가 중 적절한 조사를 고른다.
    알파벳이나 숫자의 경우 한글 발음으로 단순 치환.
    */
    private static String differentiateIGa(final char letter) {
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