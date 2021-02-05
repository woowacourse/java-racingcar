package racingcar;

import static racingcar.GoForwardOrStopUtils.MIN_GO_FORWARD_VALUE;
import static racingcar.RandomNumbersGeneratorUtils.MAX_RANDOM_NUMBER;
import static racingcar.RandomNumbersGeneratorUtils.MIN_RANDOM_NUMBER;

import racingcar.output.OutputPrinter;

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

    public static void runAllRaces(int racingTryTime) {
        OutputPrinter.printStartMessageOfAllCarRacing();

        for (int i = 0; i < racingTryTime; i++) {
            List<Integer> randomNumbers
                = RandomNumbersGeneratorUtils.generateRandomNumbersSizeOf(cars.size());
            raceOneTime(randomNumbers);
            printCurrentPositionStateOfAllCars();
            OutputPrinter.printNewLine();
        }
    }

    public static void raceOneTime(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            goForwardIfRandomNumberOfCarIsFourOrMore(cars.get(i), randomNumbers.get(i));
        }
    }

    private static void goForwardIfRandomNumberOfCarIsFourOrMore(Car car,
        int randomNumberOfCar) {
        if (GoForwardOrStopUtils.isGoForward(randomNumberOfCar)) {
            car.goForward();
        }
    }

    private static void printCurrentPositionStateOfAllCars() {
        cars.forEach(OutputPrinter::printCurrentPositionStateOfCar);
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
