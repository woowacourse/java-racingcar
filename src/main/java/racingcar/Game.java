package racingcar;

import java.util.*;

public class Game {

    private Input input;
    private Output output;

    public Game() {
        input = new Input();
        output = new Output();
    }

    public void start() {
        String[] names = inputCarNames();
        int attemptCount = inputAttemptCount();
        List<Car> cars = generateCar(names);
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
            car.movePosition();
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

    private List<String> findWinnerByPosition(int maxPosition, List<Car> cars) {
        List<String> winners = new ArrayList<>();

        cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .forEach(x -> winners.add(x.getName()));
        return winners;
    }
}
