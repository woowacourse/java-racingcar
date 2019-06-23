package racingcargame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private List<Car> winners = new ArrayList<>();

    public Winners(List<Cars> resultCars) {
        Cars resultCarsToDecideWinners = resultCars.get(resultCars.size() - 1);
        Car maxCar = decideMaxCar(resultCarsToDecideWinners);
        List<Car> winners = collectAllWinners(resultCarsToDecideWinners, maxCar);
        this.winners = winners;
    }

    private static Car decideMaxCar(Cars resultCars) {
        Car maxCar = Collections.max(resultCars.getCars());
        return maxCar;
    }

    private List<Car> collectAllWinners(Cars resultCars, Car maxCar) {
        List<Car> winners = new ArrayList<>();
        for (Car car : resultCars.getCars()) {
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
        return Collections.unmodifiableList(winners);
    }
}
