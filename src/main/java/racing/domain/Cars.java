package racing.domain;

import racing.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER = ",";
    private static final int SPLIT_THRESHOLD = -1;
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars generate(String carNames) {
        String[] splitCarNames = splitCarNames(carNames);
        List<Car> cars = Arrays.stream(splitCarNames)
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static String[] splitCarNames(String carNames) {
        return carNames.split(DELIMITER, SPLIT_THRESHOLD);
    }

    public void race() {
        cars.forEach(car -> car.move(RandomUtils.getRandomNumber(START_NUMBER, END_NUMBER)));
    }
}
