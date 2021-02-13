package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.utils.NumberGeneratingStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public static Cars from(String inputCarName) {
        String[] carNames = splitCarsName(inputCarName);
        validateDuplicatedName(carNames);

        return new Cars(
                Arrays.stream(carNames)
                        .map(Car::from)
                        .collect(Collectors.toList()));
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

    public void driveAll(NumberGeneratingStrategy numberGeneratingStrategy) {
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
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> new RuntimeException(""))
                .getPosition();
    }
}
