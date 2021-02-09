package racingcar.domain;

import racingcar.constant.Digit;
import racingcar.constant.Message;
import racingcar.utils.RandomUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplication(carNames);

        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(List<String> carNames, List<Integer> positions) {
        validateDuplication(carNames);

        cars = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get(i), positions.get(i)));
        }
    }

    private void validateDuplication(List<String> carNames) {
        Set<String> nonDuplicatedNames = new HashSet<>(carNames);

        if (nonDuplicatedNames.size() != carNames.size()) {
            throw new IllegalArgumentException(Message.CAR_NAME_DUPLICATION_ERROR.toString());
        }
    }

    public void decideMovableCar(List<Integer> randoms) {
        if (Collections.EMPTY_LIST.equals(randoms)) {
            randoms = extractRandoms(cars);
        }

        for (int i = 0; i < cars.size(); i++) {
            moveIfPossible(cars.get(i), randoms.get(i));
        }
    }

    private List<Integer> extractRandoms(List<Car> cars) {
        List<Integer> randoms = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            randoms.add(RandomUtils.nextInt(Digit.MINIMUM_RANDOM_VALUE.getDigit(),
                    Digit.MAXIMUM_RANDOM_VALUE.getDigit()));
        }
        return randoms;
    }

    public void moveIfPossible(Car car, int random) {
        if (random >= Digit.MOVEMENT_CRITERION.getDigit()) {
            car.move();
        }
    }

    public List<String> extractNames() {
        List<String> names = new ArrayList<>();

        for (Car car : cars) {
            names.add(car.getName());
        }
        return names;
    }

    public List<Integer> extractPositions() {
        List<Integer> positions = new ArrayList<>();

        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    public List<String> giveWinners() {
        return cars
                .stream()
                .filter(car -> car.isMaxPosition(extractMaxPosition()))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int extractMaxPosition() {
        return cars
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Digit.ZERO.getDigit());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
