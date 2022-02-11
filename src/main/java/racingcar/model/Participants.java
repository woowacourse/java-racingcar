package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    private static final int MOVE_MIN_VALUE = 4;
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
        cars.stream().filter(car -> isMovable()).forEach(Car::move);
    }

    public List<Car> getParticipantCars() {
        return cars;
    }

    private boolean isMovable() {
        int randomNumber = makeRandomNumberBetweenZeroAndNine();
        return randomNumber >= MOVE_MIN_VALUE;
    }

    private int makeRandomNumberBetweenZeroAndNine() {
        return (int) (Math.random() * 10);
    }
}
