package racingcar.view;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String CAR_RESULT_FORMAT = "%s : %s";
    private static final String WINNER_MESSAGE_FORMAT = "가 최종 우승했습니다.";
    private static final String NAME_DELIMITER = ", ";
    private static final String POSITION_PRINT_FORMAT = "-";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(
                String.format(CAR_RESULT_FORMAT, car.getName(), getCurrentCarPosition(car)));
        }
        System.out.println();
    }

    public void printFinalResult(Cars cars) {
        List<String> winners = cars.getWinners().stream()
            .map(car -> car.getName())
            .collect(Collectors.toList());
        String winningCarNames = String.format(NAME_DELIMITER, winners);
        System.out.print(winningCarNames + WINNER_MESSAGE_FORMAT);
    }

    private String getCurrentCarPosition(Car car) {
        return POSITION_PRINT_FORMAT.repeat(car.getPosition());
    }
}
