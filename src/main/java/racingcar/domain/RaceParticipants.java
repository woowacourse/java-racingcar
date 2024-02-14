package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceParticipants {
    private final List<Car> cars;


    public RaceParticipants(List<Car> cars) {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
