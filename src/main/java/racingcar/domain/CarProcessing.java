package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class CarProcessing {
    private CarGenerator carGenerator;

    public CarProcessing() {
        this.carGenerator = new CarGenerator();
    }

    /* For Test */
    protected CarProcessing(CarGenerator carGenerator) {
        this.carGenerator = carGenerator;
    }

    public List<Car> createCar(String[] carNames){
        return carGenerator.generateCars(carNames);
    }

    public void race(List<Car> cars) {
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

}
