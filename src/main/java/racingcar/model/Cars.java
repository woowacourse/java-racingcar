package racingcar.model;

import racingcar.util.InputValidator;
import racingcar.util.RandomNumberGenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int MINIMUM_POSITION = 0;
    public static final String JOIN_BY_COMMA = ", ";
    private static final String COMMA = ",";
    private static final String BLANK = "";
    private static final String SPACE = " ";

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

    public void race() {
        cars.forEach(car -> {
            car.move(RandomNumberGenerator.generate());
        });
    }

    public String findWinner() {
        int maxPosition = findMaxPosition();
        return findWinnerName(maxPosition);
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(x -> x))
                .orElse(MINIMUM_POSITION);
    }

    private String findWinnerName(int maxPosition) {
        return cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.joining(JOIN_BY_COMMA));
    }

    public List<Car> getCars() {
        return cars;
    }
}
