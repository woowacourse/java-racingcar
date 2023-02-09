package view;

import racingcar.Car;

import java.util.List;

import static constant.Constants.*;

public class OutputView {
    public void readCarNames() {
        println(READ_CAR_NAMES);
    }

    public void readNumberOfTry() {
        println(READ_NUMBER_OF_TRY);
    }

    public void printCarsStatus(List<Car> cars) {
        cars.forEach(car -> println(car.getName() + GAME_STATUS_DELIMITER + getPositionBars(car.getPosition())));
        printNewLine();
    }

    private void printNewLine() {
        System.out.println();
    }

    private String getPositionBars(int position) {
        return POSITION_PRINT_FORMAT.repeat(position);
    }

    public void printWinners(List<String> winnerNames) {
        println(String.join(NAME_JOINING_DELIMITER, winnerNames) + PRINT_WINNER_LIST_GUIDE);
    }

    public void printException(String exceptionMessage) {
        println(EXCEPTION_STARTER + exceptionMessage);
    }

    private void println(String value) {
        System.out.println(value);
    }
}
