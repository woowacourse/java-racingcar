package racingcar;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private static final List<Car> cars = new ArrayList<>();

    private CarRepository() {
    }

    public static void save(Car car) {
        cars.add(car);
    }

    public static void saveAll(List<Car> carsToSave) {
        cars.addAll(carsToSave);
    }

    public static void deleteAll() {
        cars.clear();
    }

    public static void race(int tryTime) {
        OutputView.printRaceResult();

        for (int i = 0; i < tryTime; i++) {
            updateAllCarsPosition();
            showAllCarsPosition(cars);
            OutputView.printNewLine();
        }

        OutputView.printWinner(getWinnerNames());
    }

    private static List<String> getWinnerNames() {
        return getWinners().stream().map(Car::getName).collect(Collectors.toList());
    }

    private static void showAllCarsPosition(List<Car> cars) {
        cars.forEach(car -> {
            OutputView.printRaceResultEachCar(car.getName(), car.getPosition());
        });
    }

    private static void updateAllCarsPosition() {
        for (Car car : cars) {
            goForwardOrStopRandomly(car);
        }
    }

    private static void goForwardOrStopRandomly(Car car) {
        int randomNumber = OneRandomNumberGeneratorUtils.generateOneRandomNumber(0, 9);

        if (GoForwardOrStop.isGoForward(randomNumber)) {
            car.goForward();
        }
    }

    public static List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return Collections.unmodifiableList(cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList()));
    }

    private static int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(RuntimeException::new);
    }
}
