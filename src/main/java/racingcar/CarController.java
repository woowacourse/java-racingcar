package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class CarController {

    public void run() {

        String carNames = getCarNamesFromUser();

        int count = getCountFromUser();

        String[] names = carNames.split(",");

        List<Car> cars = Arrays.stream(names)
                .map(Car::new)
                .collect(toList());

        OutputView.printResult(cars);

        for (int i = 0; i < count; i++) {
            playRound(cars);
            OutputView.printResult(cars);
        }

        OutputView.printWinners(findWinners(cars));
    }

    private int getCountFromUser() {
        try {
            return InputView.getCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCountFromUser();
        }
    }

    private String getCarNamesFromUser() {
        try {
            return InputView.getCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNamesFromUser();
        }
    }

    private void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.attemptToMove(getRandInt());
        }
    }

    private int getRandInt() {
        return new Random().nextInt(10);
    }

    public List<Car> findWinners(List<Car> cars) {
        Car maxPositionCar = getMaxPositionCar(cars);
        return cars.stream()
                .filter(car -> car.isSamePositionWith(maxPositionCar))
                .collect(toList());
    }

    private Car getMaxPositionCar(List<Car> cars) {
        cars.sort(Comparator.reverseOrder());
        return cars.get(0);
    }
}
