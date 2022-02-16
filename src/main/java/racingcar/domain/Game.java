package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import racingcar.utils.Constant;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private final InputView input = new InputView();
    private final OutputView output = new OutputView();

    private static final int RANDOM_RANGE = 10;

    private String[] carNames;
    private int tryNo;

    public Game(String[] carNames, int tryNo) {
        this.carNames = carNames;
        this.tryNo = tryNo;
    }

    public void start() {
        Cars cars = generateCars(carNames);
        race(tryNo, cars.getCars());
        List<String> winners = getWinner(cars.getCars());
        output.printWinner(winners);
    }

    private void race(int coin, List<Car> cars) {
        output.printResultMessage();
        for (int index = 0; index < coin; index++) {
            moveCar(cars);
            output.printPosition(cars);
        }
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.movePosition(makeRandom());
        }
    }

    private int makeRandom() {
        return (int) (Math.random() * RANDOM_RANGE);
    }

    private Cars generateCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }

    private List<String> getWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winners = findWinnerByPosition(maxPosition, cars);
        return winners;
    }

    private int findMaxPosition(List<Car> cars) {
        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);

        return cars.stream()
            .max(comparatorByPosition).get().getPosition();
    }

    private List<String> findWinnerByPosition(int maxPosition, List<Car> cars) {
        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

}
