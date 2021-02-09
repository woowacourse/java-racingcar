package racingcar.view;

import java.util.List;
import racingcar.domain.CarState;
import racingcar.domain.Result;
import racingcar.domain.Results;
import racingcar.domain.Winners;

public class OutputView {

    private static final String ONE_STEP = "-";

    private OutputView() {
    }

    ;

    public static void printResults(Results roundResults) {
        System.out.println("실행 결과");
        List<Result> results = roundResults.getResults();
        for (Result result : results) {
            printResult(result);
        }
    }

    private static void printResult(Result result) {
        List<CarState> carStates = result.getCarStates();
        for (CarState carState : carStates) {
            System.out.print(carState.getName());
            System.out.print(" : ");
            printCarSteps(carState.getPosition());
        }
        printEmptyLine();
    }

    private static void printCarSteps(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(ONE_STEP);
        }
        System.out.println(sb);
    }

    public static void printWinners(Winners winners) {
        List<String> winnerNames = winners.toList();
        String result = String.join(", ", winnerNames);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
