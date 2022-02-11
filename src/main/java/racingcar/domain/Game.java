package racingcar.domain;

import racingcar.util.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constants.SystemConstants.INCREMENT_VALUE;
import static racingcar.constants.SystemConstants.INITIAL_ROUND_NUM;

public class Game {

    private final CarRepository carRepository = new CarRepository();
    private final int totalRounds;
    private int currentRound = INITIAL_ROUND_NUM;

    public Game(String[] carNames, int totalRounds) {
        initCars(carNames);
        this.totalRounds = totalRounds;
    }

    private void initCars(String[] carNames) {
        for (String name : carNames) {
            carRepository.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return carRepository.findAllCars();
    }

    public void playRound() {
        List<Car> cars = carRepository.findAllCars();

        for (Car car : cars) {
            car.goOrNot(RandomUtils.generateNumber());
        }

        currentRound += INCREMENT_VALUE;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return getCars().stream()
                .filter((car) -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return getCars().stream()
                .mapToInt(Car::getPosition)
                .max().orElseThrow(null);
    }

    public boolean isOver() {
        return currentRound >= totalRounds;
    }
}
