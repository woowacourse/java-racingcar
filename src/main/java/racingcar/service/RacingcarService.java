package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarPerformance;
import racingcar.dto.RoundResult;

public class RacingcarService {
    public RoundResult processRound(List<Car> cars) {
        List<CarPerformance> carPerformances = new ArrayList<>();
        for (Car car : cars) {
            car.go();
            CarPerformance carPerformance = car.getCurrentPerformance();
            carPerformances.add(carPerformance);
        }
        return new RoundResult(carPerformances);
    }

    public List<String> pickOutWinners(List<Car> cars) {
        int maxDistance = Car.findMaxDistance(cars);
        return cars.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .map(Car::getName)
                .toList();
    }
}
