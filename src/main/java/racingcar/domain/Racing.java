package racingcar.domain;

import racingcar.util.RandomNumberCreator;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private List<Car> cars;
    private int numberOfTimes;

    public Racing(List<String> carNames, int numberOfTimes) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList())
        ;
        this.numberOfTimes = numberOfTimes;
    }

    public void run() {
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfTimes; ++i) {
            cars.forEach(car -> car.moveOrNot(RandomNumberCreator.create(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)));
            cars.forEach(car -> OutputView.printCarDistance(car));
            System.out.println();
        }
    }

    private int getMaxDistance() {
        int maxDistance = cars.get(0).getPosition();
        for (int i = 1; i < cars.size(); ++i) {
            maxDistance = Math.max(maxDistance, cars.get(i).getPosition());
        }
        return maxDistance;
    }

    public Winner getWinner() {
        return new Winner(cars, getMaxDistance());
    }
}

