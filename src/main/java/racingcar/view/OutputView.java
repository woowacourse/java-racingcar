package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String POSITION_SIGN = "-";

    public static void error(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void playRound() {
        System.out.println("\n실행 결과");
    }

    public static void printResult(Cars cars) {
        List<String> carsResult = cars.getResult(POSITION_SIGN);

        for (String result : carsResult) {
            System.out.println(result);
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
