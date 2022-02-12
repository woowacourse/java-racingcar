package racingcar.view;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printExecutionResult(String progressStatement) {
        System.out.println("\n실행 결과");
        System.out.println(progressStatement);
    }

    public static void printWinners(List<String> winners) {
        System.out.print(String.join(", ", winners));
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
