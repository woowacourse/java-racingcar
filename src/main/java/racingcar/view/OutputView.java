package racingcar.view;

import racingcar.domain.*;

import java.util.List;

public class OutputView {
    private static final String ONE_STEP = "-";
    private static final String WINNERS_DELIMITER = ", ";

    public static void printResults(Results roundResults) {
        System.out.println("실행 결과");
        List<Result> results = roundResults.getResults();
        for (Result result : results) {
            printResult(result);
        }
    }

    private static void printResult(Result result) {
        List<Car> cars = result.getResult();
        for (Car car : cars) {
            System.out.print(car.getName());
            System.out.print(" : ");
            printCarSteps(car.getPosition());
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
        List<String> winnerNames = winners.getWinners();
        String result = String.join(WINNERS_DELIMITER, winnerNames);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
