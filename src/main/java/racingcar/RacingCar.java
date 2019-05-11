package racingcar;

import racingcar.model.Cars;
import racingcar.model.WinningCars;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        Cars cars = makeCarList(View.inputNameOfCar());

        int numberOfTry = View.inputNumberOfTry();
        View.outputLine("실행 결과");
        for (int i = 0; i < numberOfTry; i++) {
            cars = moveCar(cars);
            View.printCars(cars);
        }
        View.printWinningCars(getWinningCars(cars));
    }

    private static Cars makeCarList(String[] carNames) {
        Cars cars = new Cars(carNames);
        return cars;
    }

    private static Cars moveCar(Cars cars) {
        cars.moveCars();
        return cars;
    }

    private static WinningCars getWinningCars(Cars cars) {
        return cars.getWinnerCars();
    }
}
