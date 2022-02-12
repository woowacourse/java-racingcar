package racingcar;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    public void play(int count, List<Car> cars) {
        OutputView.printResult(cars);
        for (int i = 0; i < count; i++) {
            playRound(cars);
            OutputView.printResult(cars);
        }
    }

    public List<Car> findWinners(List<Car> cars) {
        Car maxPositionCar = getMaxPositionCar(cars);
        return cars.stream()
                .filter(car -> car.isSamePositionWith(maxPositionCar))
                .collect(toList());
    }

    private void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.attemptToMove(getRandInt());
        }
    }

    private Car getMaxPositionCar(List<Car> cars) {
        List<Car> result = new ArrayList<>(cars);
        result.sort(Comparator.reverseOrder());
        return result.get(0);
    }

    private int getRandInt() {
        return new Random().nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
