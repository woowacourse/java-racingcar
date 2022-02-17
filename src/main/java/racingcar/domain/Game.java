package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.Input;
import racingcar.view.Output;

public class Game {

    private Input input;
    private Output output;
    private RandomNumberGenerator randomNumberGenerator;

    public Game() {
        input = new Input();
        output = new Output();
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public void start() {
        String[] names = inputCarNames();
        List<Car> cars = generateCar(names);
        int attemptCount = inputAttemptCount();
        race(attemptCount, cars);
        List<String> winners = getWinner(cars);
        output.printWinner(winners);
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
        for (String name : names) {
            cars.add(new Car(name));
        }
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
        for (Car car : cars) {
            car.movePosition(randomNumberGenerator.generateRandomNumber());
        }
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

    private List<String> findWinnerByPosition(int position, List<Car> cars) {
        return cars.stream()
            .filter(car -> car.isSamePosition(position))
            .map(car -> car.getName())
            .collect(Collectors.toList());
    }
}
