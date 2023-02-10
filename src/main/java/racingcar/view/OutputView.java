package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String CAR_RESULT_FORMAT = "%s : %s";
    private static final String WINNER_MESSAGE_FORMAT = "가 최종 우승했습니다.";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(String.format(CAR_RESULT_FORMAT, car.getName(), numberToBars(car.getPosition())));
        }
        System.out.println();
    }

    public void printFinalResult(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(","));

        System.out.print(winnerNames + WINNER_MESSAGE_FORMAT);
    }

    private String numberToBars(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
