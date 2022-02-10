package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private static final String CAR_NAME_DELIMITER = ",";

    private final List<RacingCar> cars;
    private final RandomGenerator generator = new RandomGenerator();

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public RacingCars(String carStringNames) {
        this.cars = makeRacingCars(carStringNames.split(CAR_NAME_DELIMITER));
    }

    private List<RacingCar> makeRacingCars(String[] carNames) {
        return Arrays.stream(carNames)
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    public List<String> getCarNames() {
        return cars.stream()
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(this::moveCar);
    }

    private void moveCar(RacingCar car) {
        if (generator.isMovable()) {
            car.move();
        }
    }
}
