package racingcar.controller;

import java.util.*;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.Input;
import racingcar.view.Output;

public class MainController {

    final private Input input;
    final private Output output;
    final private RandomNumberGenerator randomNumberGenerator;

    public MainController() {
        input = new Input();
        output = new Output();
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public void start() {
        List<Car> cars = generateCar(inputCarNames());
        race(inputAttemptCount(), cars);
        output.printWinner(getNamesOfWinners(cars));
    }

    private String[] inputCarNames() {
        output.inputCarNameMessage();
        return input.getNames();
    }

    private int inputAttemptCount() {
        output.inputAttemptCountMessage();
        return input.inputAttemptCount();
    }

    private List<Car> generateCar(String[] names) {
        List<Car> cars = new ArrayList<>();
        Arrays.stream(names).forEach(name -> cars.add(new Car(name)));
        return cars;
    }

    private void race(int attemptCount, List<Car> cars) {
        output.printResultMessage();
        for (int index = 0; index < attemptCount; index++) {
            moveCar(cars);
            output.printPosition(cars);
        }
    }

    private void moveCar(List<Car> cars) {
        cars.forEach(car -> car.movePosition(randomNumberGenerator.generate()));
    }

    private List<String> getNamesOfWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return findCarNamesByPosition(maxPosition, cars);
    }

    private int findMaxPosition(List<Car> cars) {
        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);
        return cars.stream()
            .max(comparatorByPosition).get().getPosition();
    }

    private List<String> findCarNamesByPosition(int position, List<Car> cars) {
        return cars.stream()
            .filter(car -> car.isSamePosition(position))
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
