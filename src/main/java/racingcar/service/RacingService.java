package racingcar.service;

import racingcar.domain.Car;
import racingcar.ui.RacingCarOutput;
import racingcar.utils.RandomIntegerGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {
    private static final int PROCEED_FlAG_NUMBER = 4;
    private final int START_RANDOM_NUMBER = 0;
    private final int END_RANDOM_NUMBER = 9;
    private final List<Car> cars;

    public RacingService(List<Car> cars) {
        this.cars = cars;
    }

    public void race(int round) {
        for (int i = 0; i < round; i++) {
            raceRound();
        }
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("우승자 파악 과정에서 에러가 발생했습니다."));
    }

    private void raceRound() {
        cars.forEach(this::decideToMoveCar);
        RacingCarOutput.printRoundResult(cars);
        System.out.println();
    }

    private void decideToMoveCar(Car car) {
        int randomNumber = RandomIntegerGenerator.random(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
        if (randomNumber >= PROCEED_FlAG_NUMBER) {
            car.proceed();
        }
    }

    private void addWinner(List<Car> winners, int maxPosition, Car car) {
        if (car.isWinner(maxPosition)) {
            winners.add(car);
        }
    }
}
