package racingcar.view;

import racingcar.constant.Message;

import java.util.List;

public class OutputView {
    public static void printCarNamesRequest() {
        System.out.println(Message.CAR_NAMES_REQUEST);
    }

    public static void printTimesRequest() {
        System.out.println(Message.TIMES_REQUEST);
    }

    public static void printResultMessage() {
        printNewLine();
        System.out.println(Message.RESULT_MESSAGE);
    }

    public static void printResult(List<String> names, List<StringBuilder> hyphens) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + Message.COLON_WITH_BLANK + hyphens.get(i));
        }
        printNewLine();
    }

    public static void printWinner(List<String> carNames) {
        System.out.print(String.join(Message.COMMA_WITH_BLANK.toString(), carNames));
        System.out.println(Message.WINNER_MESSAGE);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
