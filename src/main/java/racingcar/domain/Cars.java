package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    private final NumberGeneratingStrategy numberGeneratingStrategy;

    private Cars(List<Car> cars, NumberGeneratingStrategy numberGeneratingStrategy) {
        this.cars = new ArrayList<>(cars);
        this.numberGeneratingStrategy = numberGeneratingStrategy;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static Cars of(String inputCarName,
            NumberGeneratingStrategy numberGeneratingStrategy) {

        String[] carNames = splitCarsName(inputCarName);
        validateDuplicatedName(carNames);

        return new Cars(
                Arrays.stream(carNames)
                        .map(Car::from)
                        .collect(Collectors.toList()),
                numberGeneratingStrategy);
    }

    private static void validateDuplicatedName(String[] carNames) {
        Set<String> set = new HashSet<>(Arrays.asList(carNames));
        if (set.size() != carNames.length) {
            throw new RuntimeException();
        }
    }

    private static String[] splitCarsName(String carsName) {
        return carsName.split(",", -1);
    }

    public void driveAll() {
        cars.forEach(car -> car.drive(numberGeneratingStrategy.generateNumber()));
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition)).get().getPosition();
    }
}
