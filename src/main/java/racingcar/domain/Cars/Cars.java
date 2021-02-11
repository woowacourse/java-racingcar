package racingcar.domain.Cars;

import racingcar.domain.Car.Car;
import racingcar.domain.Cars.Exception.CarDuplicatedException;
import utils.RandomUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars from(String inputCarName) {
        String[] carNames = splitCarsName(inputCarName);
        validateDuplicated(carNames);
        List<Car> cars = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(carName -> cars.add(new Car(carName)));

        return new Cars(cars);
    }

    private static void validateDuplicated(String[] carNames) {
        Set<String> set = new HashSet<>(Arrays.asList(carNames));
        if (set.size() != carNames.length) {
            throw new CarDuplicatedException();
        }
    }

    private static String[] splitCarsName(String carsName) {
        return carsName.split(",", -1);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getCarsAfterDrive() {
        cars.forEach(car -> car.drive(RandomUtils.value()));
        return getCars();
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(comparingInt(Car::getPosition))
                .orElseThrow(() -> new RuntimeException("Cars에 값이 없습니다."))
                .getPosition();
    }
}