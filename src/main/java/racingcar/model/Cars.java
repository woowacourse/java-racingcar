package racingcar.model;

import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private int maxDistance = 0;
    public static final String CAR_NAME_INVALID = "자동차 이름이 유효하지 않습니다.";

    public Cars(List<String> carNames) {
        validateUserCount(carNames);
        validateDuplicate(carNames);
        makeCars(carNames);
    }

    public void validateUserCount(List<String> carNames) {
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException(CAR_NAME_INVALID);
        }
    }

    /*
    * 중복을 검사할 때 validateDuplicate 메소드 안에 Collections.frequency를 쓰는 것과
    * Car이라는 클래스에 .Equals와 .hascode를 오버라이드한 후 List.contains를 활용하여 중복체크를 하는 것,
    * 둘 중 어느 것이 나은가요?
    */
    public void validateDuplicate(List<String> carNames) {
        if (!carNames.stream()
                .filter(count -> Collections.frequency(carNames, count) > 1)
                .collect(Collectors.toSet()).isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_INVALID);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars() {
        cars.stream()
                .forEach(car -> car.movePosition(RandomUtils.nextInt(0, 9)));
        updateMaxDistance();
    }

    public void updateMaxDistance() {
        maxDistance = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);
    }

    public void makeCars(List<String> names) {
        names.stream()
                .forEach(name -> cars.add(new Car(name)));
    }

    public int getMaxDistance() {
        return maxDistance;
    }
}
