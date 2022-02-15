package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.RandomIntegerGenerator;

public class RacingGame {
    private static final int MIN_POSITION = 0;
    private static final int START_RANDOM_NUMBER = 0;
    private static final int END_RANDOM_NUMBER = 9;
    private static final int PROCEED_FlAG_NUMBER = 4;
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> race() {
        cars.forEach(this::randomDrawAndProceed);
        return cars;
    }

    private void randomDrawAndProceed(Car car) {
        if(RandomIntegerGenerator.random(START_RANDOM_NUMBER, END_RANDOM_NUMBER) > PROCEED_FlAG_NUMBER) {
            car.proceed();
        }
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = findMaxPosition();
        cars.forEach((car) -> addWinner(winners, maxPosition, car));
        return winners;
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }

    private void addWinner(List<Car> winners, int maxPosition, Car car) {
        if (car.isHere(maxPosition)) {
            winners.add(car);
        }
    }
}
