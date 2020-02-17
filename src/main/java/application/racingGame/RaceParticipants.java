package application.racingGame;

import java.util.*;

public class RaceParticipants {

    private List<Car> cars;

    public RaceParticipants(List<String> carNames) {
        this.cars = getCarList(carNames);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private List<Car> getCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}

