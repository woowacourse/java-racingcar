package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    private final List<Car> cars;

    public Participants() {
        this.cars = new ArrayList<>();
    }

    public void participateInRacing(Car car) {
        this.cars.add(car);
    }

    public Integer participateSize() {
        return this.cars.size();
    }

    public void race() {
        for (Car car : cars) {
           if (isMovable()) {
               car.move();
           }
        }
    }

    public List<Car> getParticipantCars() {
        return cars;
    }

    private boolean isMovable() {
        int randomNumber = (int) (Math.random() * 10);
        return randomNumber >= 4;
    }
}
