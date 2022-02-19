package racingcar.model;

import racingcar.util.InputValidator;
import racingcar.util.NumberGenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String COMMA = ",";
    private static final String BLANK = "";
    private static final String SPACE = " ";
    public static final int MINIMUM_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars initCars(String carNames) {
        return new Cars(splitCars(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public static List<String> splitCars(String carNames) {
        InputValidator.validateNameInput(carNames);
        List<String> splitCarNames = Arrays.asList(splitNameWithoutSpace(carNames));
        InputValidator.validateEmptyCarName(splitCarNames);
        InputValidator.validateCarNameLength(splitCarNames);
        InputValidator.validateDuplicateName(splitCarNames);

        return splitCarNames;
    }


    private static String[] splitNameWithoutSpace(String carNames) {
        return carNames.replaceAll(SPACE, BLANK).split(COMMA);
    }

    public void race(NumberGenerator numberGenerator) {
        cars.forEach(car -> {
            car.move(numberGenerator);
        });
    }

    public int findWinnerCarPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(position -> position))
                .orElse(MINIMUM_POSITION);
    }

    public Cars findWinnerCars() {
        int maxPosition = findWinnerCarPosition();
        List<Car> winnerCars = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return new Cars(winnerCars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
