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

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void decideMovableCar(List<Integer> randoms) {
        if (Collections.EMPTY_LIST.equals(randoms)) {
            randoms = getRandoms(cars);
        }

        for (int i = 0; i < cars.size(); i++) {
            moveIfPossible(cars.get(i), randoms.get(i));
        }
    }

    private List<Integer> getRandoms(List<Car> cars) {
        List<Integer> randoms = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            int random = RandomUtils.nextInt(Digit.MINIMUM_RANDOM_VALUE.getDigit(),
                    Digit.MAXIMUM_RANDOM_VALUE.getDigit());

            randoms.add(random);
        }

        return randoms;
    }

    public void moveIfPossible(Car car, int random) {
        if (random >= Digit.MOVEMENT_CRITERION.getDigit()) {
            car.move();
        }
    }
}
