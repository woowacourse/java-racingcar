package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingService {

    private static final CarRacingService INSTANCE = new CarRacingService();

    private CarRacingService() {
    }

    public static CarRacingService getInstance() {
        return INSTANCE;
    }

    public void carRacingGame(List<String> carNamesList, int raceGameCount,
        RangedRandomNumberPicker numberPicker) {
        List<Car> cars = getCars(carNamesList, numberPicker);
        Racing racing = new Racing(cars, raceGameCount);
        racing.race();
    }

    private List<Car> getCars(List<String> carNamesList, RangedRandomNumberPicker numberPicker) {
        return carNamesList.stream()
            .map(carName -> new RandomMovingCar(carName, numberPicker))
            .collect(Collectors.toList());
    }
}
