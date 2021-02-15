package racingcar.model;

import racingcar.utils.RandomUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    public static final String CAR_NAME_INVALID = "자동차 이름이 유효하지 않습니다.";
    public static final int MAX_RANDOM_RANGE = 9;
    public static final int MIN_RANDOM_RANGE = 0;

    private List<Car> cars;
    private int maxDistance = 0;

    public Cars(List<Car> cars) {
        validateUserCount(cars);
        validateDuplicate(cars);
        this.cars = cars;
    }

    public Cars() {

    }

    public void assignCars(List<Car> cars){
        validateUserCount(cars);
        validateDuplicate(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars() {
        cars.stream()
                .forEach(car -> car.movePosition(RandomUtils.nextInt(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE)));
        updateMaxDistance();
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void updateMaxDistance() {
        maxDistance = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);
    }

    private void validateUserCount(List<Car> cars) {
        if (cars.size() <= 1) {
            throw new IllegalArgumentException(CAR_NAME_INVALID);
        }
    }

    /*
     * 중복을 검사할 때 validateDuplicate 메소드 안에 Collections.frequency를 쓰는 것과
     * Car이라는 클래스에 .Equals와 .hascode를 오버라이드한 후 List.contains를 활용하여 중복체크를 하는 것,
     * 둘 중 어느 것이 나은가요?
     */
    private void validateDuplicate(List<Car> cars) {
        if (!cars.stream()
                .filter(count -> Collections.frequency(cars, count) > 1)
                .collect(Collectors.toSet()).isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_INVALID);
        }
    }
}
