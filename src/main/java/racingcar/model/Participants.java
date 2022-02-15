package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
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
        for (RacingCar car : cars) {
            car.tryMove(makeRandomNumberBetweenZeroAndNine());
        }
    }

    public List<Car> getParticipantCars() {
        return Collections.unmodifiableList(cars);
    }

    private int makeRandomNumberBetweenZeroAndNine() {
        return (int) (Math.random() * 10);
    }
}
