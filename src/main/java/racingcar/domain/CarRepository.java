package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.util.RandomUtil.generateRandomNumber;


public class CarRepository {

    private static final String DUPLICATED = "[ERROR] 중복된 자동차 이름은 허용되지 않습니다.";

    private Set<Car> cars = new HashSet<>();

    public CarRepository(String[] names) {
        validateDuplication(names);

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveAllCars() {
        for (Car car : cars) {
            car.move(generateRandomNumber());
        }
    }

    public List<String> selectWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(c -> c.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<CarDTO> getExecutionResult() {
        List<CarDTO> executionResult = new ArrayList<>();

        for (Car car : cars) {
            executionResult.add(new CarDTO(car.getName(), car.getPosition()));
        }

        return executionResult;
    }

    public Car getCar(String name) {
        return cars.stream()
                .filter(c -> c.getName().equals(name))
                .collect(Collectors.toList())
                .get(0);
    }

    private static void validateDuplication(String[] carNames) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(carNames));

        if (hashSet.size() < carNames.length) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
