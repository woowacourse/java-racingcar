package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> racingCars;

    public Cars() {
        this.racingCars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return racingCars;
    }

    public void insertCar(Car car) {
        racingCars.add(car);
    }

    public void insertCarFromCarNames(String[] carNames) {
        for (String carName : carNames) {
            insertCar(new Car(carName, 0));
        }
    }

    public void moveRound() {
        for (Car car : racingCars) {
            car.move();
        }
    }

    public List<String> getWinner() {
        int maxPosition = racingCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return racingCars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
