package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class CarProcessing {
    private List<Car> cars;
    private CarGenerator carGenerator;

    public CarProcessing() {
        this.carGenerator = new CarGenerator();
        this.cars = carGenerator.getCars();
    }

    /* For Test */
    protected CarProcessing(CarGenerator carGenerator, List<Car> cars) {
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

    /* For Test */
    protected List<Car> race(List<Car> cars, int num) {
        for (Car car : cars) {
            car.move(num);
        }

        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarProcessing carProcessing = (CarProcessing) o;
        return Objects.equals(cars, carProcessing.cars) &&
                Objects.equals(carGenerator, carProcessing.carGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, carGenerator);
    }
}
