package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Game {

    private Input input;
    private Output output;

    public Game() {
        input = new Input();
        output = new Output();
    }

    public void start() {
        String[] names = inputCarNames();
        int coin = inputCoin();
        List<Car> cars = generateCar(names);
        race(coin, cars);
        List<String> winners = getWinner(cars);
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
            car.movePosition();
        }
    }

    private List<Car> generateCar(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
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

    private String[] inputCarNames() {
        output.inputCarNameMessage();
        return input.getNames();
    }

    private int inputCoin() {
        output.inputCoinMessage();
        return input.getCoin();
    }
}
