package view;

import racingcar.Car;

import java.io.IOException;
import java.util.List;

import static constant.Constants.READ_CAR_NAMES;
import static constant.Constants.READ_NUMBER_OF_TRY;

public class OutputView {
    public void readCarNames() {
        print(READ_CAR_NAMES);
    }

    public void readNumberOfTry() {
        print(READ_NUMBER_OF_TRY);
    }

    public void printCarsStatus(List<Car> cars) {
        cars.forEach(car -> print(car.getName() + " : " + getPositionBars(car.getPosition())));
    }

    private String getPositionBars(int position) {
        return "-".repeat(position);
    }

    public void printException(IOException ioException) {
        print(ioException.getMessage());
    }

    private void print(String value) {
        System.out.println(value);
    }
}
