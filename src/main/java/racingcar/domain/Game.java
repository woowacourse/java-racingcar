package racingcar.domain;

import racingcar.util.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.ValidatorUtils.validateNoDuplicateCar;

public class Game {

    private static final int ROUND_INCREMENT_UNIT = 1;
    private static final int NON_EXISTING_MAX_POSITION = -1;

    private final CarRepository carRepository = new CarRepository();
    private final int totalRounds;
    private int currentRound = 0;

    public Game(String[] carNames, int totalRounds) {
        initCars(carNames);
        this.totalRounds = totalRounds;
    }

    private void initCars(String[] carNames) {
        for (String name : carNames) {
            carRepository.add(new Car(name));
        }
        validateNoDuplicateCar(carRepository.findAllCars());
    }

    public List<Car> getCars() {
        return carRepository.findAllCars();
    }

    public void playRound() {
        List<Car> cars = carRepository.findAllCars();

        for (Car car : cars) {
            car.goOrNot(RandomUtils.generateNumber());
        }

        currentRound += ROUND_INCREMENT_UNIT;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return getCars().stream()
            .filter((car) -> car.hasSamePosition(maxPosition))
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return getCars().stream()
            .mapToInt(Car::getPosition)
            .max().orElse(NON_EXISTING_MAX_POSITION);
    }

    public boolean isOver() {
        return currentRound >= totalRounds;
    }
}
