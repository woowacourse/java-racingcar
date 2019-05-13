package domain;

import java.util.List;

public class RacingTrial {
    private final CarMoveFilter carMoveFilter;// = new CarMoveFilter();

    public RacingTrial(CarMoveFilter carMoveFilter) {
        this.carMoveFilter = carMoveFilter;
    }

    public List<Car> runTrial(List<Car> cars) {
        List<Car> carsForMoving = carMoveFilter.adjust(cars);

        for (Car car : carsForMoving) {
            car.move();
        }
        return cars;
    }
}
