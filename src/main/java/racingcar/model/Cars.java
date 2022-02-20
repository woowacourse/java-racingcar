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

//    public static Cars initCars(String carNames) {
//        return new Cars(splitCars(carNames).stream()
//                .map(Car::new)
//                .collect(Collectors.toList()));
//    }

    public static Cars initCars(List<Car> cars) {
        validateNameInput(cars);
        validateDuplicateName(cars);
        return new Cars(cars);
    }

    private static void validateNameInput(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("최소 1개 이상의 자동차가 입력되어야 합니다.");
        }
    }

    private static void validateDuplicateName(List<Car> cars) {
        long distinctNum = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (distinctNum != cars.size()) {
            throw new IllegalArgumentException("자동차의 이름에 중복이 포함되면 안됩니다.");
        }
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
            car.move(numberGenerator.generate());
        });
    }

    public Cars findWinnerCars() {
        int maxPosition = findWinnerCarPosition();
        List<Car> winnerCars = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return new Cars(winnerCars);
    }

    private int findWinnerCarPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(position -> position))
                .orElse(MINIMUM_POSITION);
    }

    public String getCarNames(String delimiter) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(delimiter));
    }

    public List<Car> getCars() {
        return cars;
    }
}
