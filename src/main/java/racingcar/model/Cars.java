package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int DEFAULT_POSITION = 0;

    private List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = new ArrayList<>();
        insertCarFromCarNames(carNames);
    }

    public List<Car> getRacingCars() {
        return cars;
    }

    public void insertCar(Car car) {
        cars.add(car);
    }

    public void insertCarFromCarNames(String[] carNames) {
        for (String carName : carNames) {
            insertCar(new Car(carName, DEFAULT_POSITION));
        }
    }

    public void moveRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
