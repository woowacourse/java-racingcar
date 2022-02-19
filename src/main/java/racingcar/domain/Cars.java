package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.util.RandomUtil.generateRandomNumber;


public class Cars {

    private static final String DUPLICATED = "[ERROR] 중복된 자동차 이름은 허용되지 않습니다.";

    private Set<Car> cars = new HashSet<>();

    public Cars() {
    }

    public Cars(String[] names) {
        validateDuplication(names);

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public Cars(Map<String, Integer> carInfo) {
        Set<String> names = carInfo.keySet();
        validateDuplication(names.toArray(new String[names.size()]));

        for (String name : names) {
            cars.add(new Car(name, carInfo.get(name)));
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move(generateRandomNumber());
        }
    }

    public List<String> selectWinners() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(c -> c.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Set<Car> getCars() {
        return this.cars;
    }

    private void validateDuplication(String[] carNames) {
        Set<String> set = new HashSet<>(Arrays.asList(carNames));

        if (set.size() < carNames.length) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
