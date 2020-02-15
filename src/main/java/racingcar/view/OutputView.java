package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.result.RacingResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String AND = ", ";

    public static void printResult(RacingResult racingResult) {
        printValue("실행 결과");
        printValue(racingResult.getResult());
    }

    public static void printWinners(List<Car> winners) {
        printValue("우승자 명단");

        List<String> winnerNames = winners.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
        String winnerResult = String.join(AND, winnerNames);

        printValue(winnerResult);
    }

    public static void printValue(String value) {
        System.out.println(value);
    }
}
