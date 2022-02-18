package racingcar.view;

import racingcar.domain.CarDTO;
import racingcar.domain.ExecutionResult;

import java.util.List;

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

    private static void printExecutionResult(List<CarDTO> cars) {
        for (CarDTO car : cars) {
            String positionSign = SIGN_OF_POSITION.repeat(car.getPosition());
            System.out.println(car.getName() + " : " + positionSign);
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
