package racingcar.model;

import java.util.ArrayList;
import java.util.List;

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

    public void moveRound() {
        for (Car car : racingCars) {
            car.move();
        }
    }

    public String[] getWinner() {
        int maxPosition = racingCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return racingCars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .toArray(String[]::new);
    }
}
