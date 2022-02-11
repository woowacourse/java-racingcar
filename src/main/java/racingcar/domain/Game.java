package racingcar.domain;

import racingcar.util.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final CarRepository carRepository = new CarRepository();
    private int currentRound = 0;
    private final int totalRounds;

    public Game(String[] carNames, int totalRounds) {
        initCars(carNames);
        this.totalRounds = totalRounds;
    }

    private void initCars(String[] carNames) {
        for (String name : carNames) {
            carRepository.add(new Car(name));
        }
    }

    public void playRound() {
        List<Car> cars = carRepository.findAllCars();

        for (Car car : cars) {
            car.goOrNot(RandomUtils.generateNumber());
        }

        currentRound += 1;
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
                .max().orElse(0);
    }

    public List<Car> getCars() {
        return carRepository.findAllCars();
    }

    public boolean isOver() {
        return currentRound >= totalRounds;
    }
}
