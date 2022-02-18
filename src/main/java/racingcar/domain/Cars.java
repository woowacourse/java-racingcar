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

    public void move() {
        for (Car car : cars) {
            car.move(generateRandomNumber());
        }
    }

    public List<CarDTO> convertToDTO() {
        List<CarDTO> carDTOs = new ArrayList<>();

        for (Car car : cars) {
            carDTOs.add(new CarDTO(car));
        }

        return carDTOs;
    }

    public List<String> selectWinners() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(c -> c.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Car getCar(String name) {
        return cars.stream()
                .filter(c -> c.getName().equals(name))
                .collect(Collectors.toList())
                .get(0);
    }

    private void validateDuplication(String[] carNames) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(carNames));

        if (hashSet.size() < carNames.length) {
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
