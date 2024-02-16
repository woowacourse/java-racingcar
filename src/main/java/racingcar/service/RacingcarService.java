package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarPerformance;
import racingcar.dto.RoundResult;
import racingcar.domain.RandomOilGenerator;

public class RacingcarService {

    public RoundResult processRound(List<Car> cars) {
        List<CarPerformance> carPerformances = new ArrayList<>();
        for (Car car : cars) {
            car.goIfOilEnough(decideOilAmount());
            CarPerformance carPerformance = car.getCurrentPerformance();
            carPerformances.add(carPerformance);
        }
        return new RoundResult(carPerformances);
    }

    public List<String> pickOutWinners(List<Car> cars) {
        int maxDistance = Car.findMaxDistance(cars);
        List<Car> winners =  cars.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .toList();
        return Car.mapCarsToName(winners);
    }

    private int decideOilAmount() {
        return RandomOilGenerator.generate();
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        Car.validateUniqueCarNames(cars);
        return cars;
    }
}
