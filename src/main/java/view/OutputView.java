package view;

import racingcar.Car;

import java.io.IOException;
import java.util.List;

import static constant.Constants.READ_CAR_NAMES;
import static constant.Constants.READ_NUMBER_OF_TRY;

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

    public void printException(IOException ioException) {
        println(ioException.getMessage());
    }

    private void println(String value) {
        System.out.println(value);
    }
}
