package domain;

import java.util.ArrayList;

public class RacingTrial {
    private final CarMoveFilter carMoveFilter;// = new CarMoveFilter();

    public RacingTrial(CarMoveFilter carMoveFilter) {
        this.carMoveFilter = carMoveFilter;
    }

    public ArrayList<Car> runTrial(ArrayList<Car> cars) {
        ArrayList<Car> carsForMoving = carMoveFilter.adjust(cars);

        for (Car car : carsForMoving) {
            car.move();
        }
        return cars;
    }
}
