package carracinggame.domain;

import carracinggame.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public void makeCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void run() {
        for (Car car : cars) {
            car.move(RandomUtils.random());
        }
    }

    public Car getCar(int i) {
        return cars.get(i);
    }

    public List<Car> findWinner() {
        Winner winner = new Winner();
        return winner.findWinner(this.cars);
    }

}
