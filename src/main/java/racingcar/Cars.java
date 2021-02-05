package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import utils.RandomUtils;

import static java.util.Comparator.*;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars from(String inputCarName) {
        String[] carNames = splitCarsName(inputCarName);
        validate(carNames);
        List<Car> cars = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(carName -> cars.add(new Car(carName)));

        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private static void validate(String[] carNames) {
        Set<String> set = new HashSet<>(Arrays.asList(carNames));
        if (set.size() != carNames.length) {
            throw new RuntimeException();
        }
    }

    private static String[] splitCarsName(String carsName) {
        return carsName.split(",", -1);
    }

    public void allCarsDrive() {
        cars.forEach(car -> car.drive(RandomUtils.nextInt(0, 9)));
        OutputView.printCarsAfterEachTurn(cars);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(comparingInt(Car::getPosition))
                .get()
                .getPosition();
    }
}