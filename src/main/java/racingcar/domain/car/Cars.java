package racingcar.domain.car;

import racingcar.domain.car.util.RandomNumberGenerator;

import java.util.*;

public class Cars {
    private static final String ERROR_EXIST_DUPLICATED_CAR_NAMES_MESSAGE = "[ERROR] 중복되는 자동차이름이 존재합니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateCars(List<Car> cars) {
        Set<Car> distinctCars = new HashSet<>(cars);
        if (distinctCars.size() != cars.size()) {
            throw new IllegalArgumentException(ERROR_EXIST_DUPLICATED_CAR_NAMES_MESSAGE);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void play(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generate());
        }
    }

    public int extractMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = getMaxPosition(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private int getMaxPosition(int maxPosition, int position) {
        if (maxPosition < position) {
            return position;
        }

        return maxPosition;
    }

    public List<Car> extractSamePosition(int maxPosition) {
        List<Car> cars = new ArrayList<>();
        for (Car car : this.cars) {
            addSamePositionCar(maxPosition, cars, car);
        }

        return cars;
    }

    private void addSamePositionCar(int maxPosition, List<Car> cars, Car car) {
        if (car.equalToPosition(maxPosition)) {
            cars.add(car);
        }
    }
}
