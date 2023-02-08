package view;

import racingcar.Car;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static constant.Constants.*;

public class OutputView {
    public void readCarNames() {
        println(READ_CAR_NAMES);
    }

    public void readNumberOfTry() {
        println(READ_NUMBER_OF_TRY);
    }

    public void printCarsStatus(List<Car> cars) {
        cars.forEach(car -> println(car.getName() + " : " + getPositionBars(car.getPosition())));
        printNewLine();
    }

    private void printNewLine() {
        System.out.println();
    }

    private String getPositionBars(int position) {
        return "-".repeat(position);
    }

    public void printWinners(List<String> winnerNames) {
        String winnerList = winnerNames.stream().collect(Collectors.joining(", "));
        println(winnerList + PRINT_WINNER_LIST_GUIDE);
    }

    private void println(String value) {
        System.out.println(value);
    }

    public void printException(String exceptionMessage) {
        println("[ERROR] " + exceptionMessage);
    }
}
