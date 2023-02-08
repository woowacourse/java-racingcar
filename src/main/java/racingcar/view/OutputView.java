package racingcar.view;

import racingcar.model.car.Cars;

public class OutputView {

    public void printCarsResult(Cars cars) {
        String carsPositionFormat = cars.getCarsPositionFormat();
        System.out.println(carsPositionFormat);
    }
}
