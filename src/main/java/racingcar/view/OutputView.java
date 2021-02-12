package racingcar.view;

import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.view.Marks.COMMA;

public class OutputView {
    public static final String EXECUTION_RESULT = "실행 결과";
    public static final String MESSAGE_GAME_RESULT = "가 최종 우승했습니다.";

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printCarStates(Cars cars) {
        cars.getCarList().stream().forEach(car -> {
            System.out.println(car.toString());
        });
        System.out.println();
    }

    public static void printWinner(Cars cars) {
        List<CarName> winners = cars.getWinnersName();
        List<String> winnerNames = winners.stream().map(CarName::toString).collect(Collectors.toList());
        Collections.sort(winnerNames);
        System.out.println(String.join(COMMA, winnerNames) + MESSAGE_GAME_RESULT);
    }
}
