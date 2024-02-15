package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarPerformance;
import racingcar.dto.RoundResult;
import racingcar.util.RandomNumberGenerator;

public class RacingcarService {

    private static final int MIN_OIL_AMOUNT = 0;
    private static final int MAX_OIL_AMOUNT = 9;

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
        return RandomNumberGenerator.generate(MIN_OIL_AMOUNT, MAX_OIL_AMOUNT);
    }
}
