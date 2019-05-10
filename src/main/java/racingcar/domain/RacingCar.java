package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class RacingCar {
    private List<Car> cars = null;
    private CarGenerator carGenerator;

    public RacingCar() {
        this.carGenerator = new CarGenerator();
        this.cars = carGenerator.getCars();
    }

    public RacingCar(CarGenerator carGenerator, List<Car> cars) {
        this.carGenerator = carGenerator;
        this.cars = cars;
    }

    public List<Car> createCar(String[] carNames){
        carGenerator.generateCars(carNames);
        return carGenerator.getCars();
    }

    public void race() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> race(List<Car> cars, int num) {
        for (Car car : cars) {
            car.move(num);
        }

        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(cars, racingCar.cars) &&
                Objects.equals(carGenerator, racingCar.carGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, carGenerator);
    }
}
