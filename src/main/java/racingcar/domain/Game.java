package racingcar.domain;

import racingcar.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

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
        List<Car> winners = new ArrayList<>();
        int maxPosition = 0;

        for (Car car : getCars()) {
            int currentPosition = car.getPosition();
            if (maxPosition > currentPosition) {
                continue;
            }
            if (maxPosition < currentPosition) {
                winners.clear();
            }
            winners.add(car);
            maxPosition = currentPosition;
        }
        return winners;
    }

    public List<Car> getCars() {
        return carRepository.findAllCars();
    }

    public boolean isOver() {
        return currentRound >= totalRounds;
    }
}
