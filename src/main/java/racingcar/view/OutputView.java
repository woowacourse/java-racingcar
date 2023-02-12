package racingcar.view;

import java.util.List;

public class OutputView {
    private final String ERROR_PREFIX = "[ERROR] ";
    private final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private final String FINAL_RESULT_MESSAGE = "%s가 최종 우승했습니다.";

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printExecutionResult(String name, int position) {
        System.out.println(name + " : " + changePositionToBars(position));
    }

    private String changePositionToBars(int position) {
        return "-".repeat(position);
    }

    public void printFinalResult(List<String> names) {
        String winnerNames = String.join(", ", names);
        System.out.println(String.format(FINAL_RESULT_MESSAGE,winnerNames));
    }
}
