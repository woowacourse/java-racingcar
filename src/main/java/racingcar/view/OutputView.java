package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String CAR_NAMES_REQUEST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TIMES_REQUEST = "시도할 회수는 몇회인가요?";
    private static final String BLANK = " ";
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String COMMA_WITH_BLANK = COMMA + BLANK;
    private static final String COLON_WITH_BLANK = BLANK + COLON + BLANK;
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printCarNamesRequest() {
        System.out.println(CAR_NAMES_REQUEST);
    }

    public static void printTimesRequest() {
        System.out.println(TIMES_REQUEST);
    }

    public static void printResultMessage() {
        printNewLine();
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(List<String> names, List<StringBuilder> hyphens) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + COLON_WITH_BLANK + hyphens.get(i));
        }
        printNewLine();
    }

    public static void printWinner(List<String> carNames) {
        System.out.print(String.join(COMMA_WITH_BLANK, carNames));
        System.out.println(WINNER_MESSAGE);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
