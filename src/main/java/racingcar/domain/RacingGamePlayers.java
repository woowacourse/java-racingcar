package racingcar.domain;

import racingcar.utils.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGamePlayers {
    private static final int RANDOM_NUM_SCOPE = 10;
    private List<Car> cars;

    public RacingGamePlayers(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> copyAllCars(List<Car> cars) {
        return cars.stream().map(car -> {
            try {
                return car.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException();
            }
        }).collect(Collectors.toList());
    }

    public RacingGamePlayers clone() {
        return new RacingGamePlayers(copyAllCars(cars));
    }

    public void proceedOneRound() {
        for (Car car : this.cars) {
            car.accelerate(generateRandomNum());
        }
    }

    private int generateRandomNum() {
        return new Random().nextInt(RANDOM_NUM_SCOPE);
    }

    public List<String> getNamesOfWinners() {
        return findWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> findWinners() {
        Car winner = findOneWinner();
        return cars.stream()
                .filter(car -> car.isEqualPosition(winner))
                .collect(Collectors.toList());
    }

    private Car findOneWinner() {
        return Collections.max(cars);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car player : cars) {
            stringBuilder.append(player);
            stringBuilder.append(StringUtils.ENTER);
        }
        return stringBuilder.toString();
    }
}
