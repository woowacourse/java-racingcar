package racingcar.view;

import racingcar.domain.ExecutionResult;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String SIGN_OF_POSITION = "-";

    private OutputView() {
    }

    public static void printTotalExecutionResult(List<ExecutionResult> totalExecutionResults) {
        System.out.println("\n실행 결과");
        for (ExecutionResult executionResult : totalExecutionResults) {
            printExecutionResult(executionResult.getExecutionResult());
        }
    }

    private static void printExecutionResult(Map<String, Integer> cars) {
        for (String name : cars.keySet()) {
            String positionSign = SIGN_OF_POSITION.repeat(cars.get(name));
            System.out.println(name + " : " + positionSign);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print(String.join(", ", winners));
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
