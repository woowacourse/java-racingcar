package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.result.Result;
import racingcar.domain.result.Results;

import java.util.List;

public class OutputView {
    private static final String ONE_STEP = "-";
    private static final String WINNERS_DELIMITER = ", ";

    public static void printResults(Results roundResults) {
        System.out.println("실행 결과");
        List<Result> results = roundResults.getResults();
        results.forEach(OutputView::printResult);
        printWinners(roundResults);
    }

    private static void printResult(Result result) {
        List<Car> cars = result.getResult();
        for (Car car : cars) {
            System.out.print(car.getName().getValue());
            System.out.print(" : ");
            printCarSteps(car.getPosition().getValue());
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

    private static void printWinners(Results results) {
        List<String> winnerNames = results.findWinners();
        String result = String.join(WINNERS_DELIMITER, winnerNames);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
