package view;

import domain.Car;
import domain.Cars;
import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "실행 결과";
    private static final String CAR_STATUS_FORMAT = "%s : %s\n";
    private static final String RESULT_WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String DELIMITER = ", ";
    private static final String BAR = "-";

    public void printStart(Cars cars) {
        printNewLine();
        System.out.println(START_MESSAGE);
        printCarsStatus(cars);
    }

    private void printNewLine() {
        System.out.println();
    }

    public void printCarsStatus(Cars cars) {
        cars.forEach(this::printCarStatus);
        printNewLine();
    }

    private void printCarStatus(Car car) {
        System.out.printf(CAR_STATUS_FORMAT, car.getName(), toBar(car.getPosition()));
    }

    private String toBar(int count) {
        return BAR.repeat(count);
    }

    public void printWinners(List<String> carNames) {
        String result = carNames.get(0);
        boolean isCoWinner = carNames.size() > 1;
        if (isCoWinner) {
            result = String.join(DELIMITER, carNames);
        }
        System.out.printf(RESULT_WINNER_MESSAGE, result);
    }

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
