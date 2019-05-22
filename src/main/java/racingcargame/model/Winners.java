package racingcargame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private List<Car> winners = new ArrayList<>();

    public Winners(Cars resultCars) {
        Car maxCar = decideMaxCar(resultCars);
        List<Car> winners = collectAllWinners(resultCars, maxCar);
        this.winners = winners;
    }

    private static Car decideMaxCar(Cars resultCars) {
        Car maxCar = Collections.max(resultCars.getCars());
        return maxCar;
    }

    private List<Car> collectAllWinners(Cars resultCars, Car maxCar) {
        List<Car> winners = new ArrayList<>();
        for (Car car: resultCars.getCars()) {
            checkMax(car, maxCar, winners);
        }
        return winners;
    }

    private static void checkMax(Car car, Car maxCar, List<Car> winners) {
        if (car.isMax(maxCar)) {
            winners.add(car);
        }
    }

    public List<Car> getWinners() {
        return winners;
    }
}
