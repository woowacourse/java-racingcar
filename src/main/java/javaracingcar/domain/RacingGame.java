package javaracingcar.domain;

import javaracingcar.view.OutputView;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MIN_CAN_MOVE_NUMBER = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private List<Car> cars;
    private int trial;

    private RacingGame(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public static RacingGame init(List<String> carNames, int trial) {
        validateNonZeroElement(carNames);
        validateDistinctNames(carNames);
        return new RacingGame(generateCars(carNames), trial);
    }

    private static void validateNonZeroElement(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
        }
    }

    private static void validateDistinctNames(List<String> carNames) {
        if (isDistinctNames(carNames)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private static boolean isDistinctNames(List<String> carNames) {
        return carNames.stream()
                       .distinct()
                       .count() != carNames.size();
    }

    public static List<Car> generateCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.generateCar(name));
        }
        return cars;
    }

    public List<String> getCarNames() {
        return cars.stream()
                   .map(Car::getName)
                   .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTrial() {
        return trial;
    }

    public void playRace() {
        while (trial > 0) {
            playOneRound();
            trial--;
        }
    }

    private void playOneRound() {
        playMoveOrStop();
        OutputView.printRoundResult(cars); // TODO:Domain 로직에서 View 를 호출하는 것이 부자연스러움 -> Controller를 호출하여 해결?
    }

    private void playMoveOrStop() {
        cars.forEach(this::playMoveOrStop);
    }

    private void playMoveOrStop(Car car) {
        if (generateRandomNumber() >= MIN_CAN_MOVE_NUMBER) {
            car.move();
        }
    }

    private int generateRandomNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
