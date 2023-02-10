package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String CAR_RESULT_FORMAT = "%s : %s";
    private static final String WINNER_MESSAGE_FORMAT = "가 최종 우승했습니다.";
    private static final String NAME_DELIMITER = ", ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(
                String.format(CAR_RESULT_FORMAT, car.getName(), car.getMovePosition()));
        }
        System.out.println();
    }

    public void printFinalResult(Cars cars) {
        List<Car> winners = cars.getWinners();
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : winners) {
            stringBuilder.append(car.getName() + NAME_DELIMITER);
        }
        String winnerNames = stringBuilder.toString();
        System.out.print(winnerNames.substring(0, winnerNames.length()-2) + WINNER_MESSAGE_FORMAT);
    }
}
