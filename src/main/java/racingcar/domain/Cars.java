package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private static final int MIN_CARS_SIZE = 2;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateCarsSize(cars);
        validateDuplicatedCarNames(cars);
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars from(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.from(name));
        }
        return new Cars(cars);
    }

    private void validateCarsSize(List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException("자동차는 2대 이상 이어야 합니다.");
        }
    }

    private void validateDuplicatedCarNames(List<Car> cars) {
        Set<Car> carsSet = new HashSet<>(cars);
        if (cars.size() != carsSet.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되면 안 됩니다.");
        }
    }

    public void tryToMove(List<Integer> values) {
        if (values.size() != cars.size()) {
            throw new IllegalArgumentException("경주할 자동차의 수의 크기만큼 숫자 배열을 입력해주셔야 합니다.");
        }
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int value = values.get(i);
            car.tryToMove(value);
        }
    }

    public Result getResult() {
        List<CarState> carStates = new ArrayList<>();
        for (Car car : cars) {
            carStates.add(car.getCarState());
        }
        return Result.from(carStates);
    }

    public int size() {
        return cars.size();
    }
}
