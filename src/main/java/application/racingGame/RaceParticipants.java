package application.racingGame;

import java.util.ArrayList;
import java.util.List;

public class RaceParticipants {
    public static final int INIT_CAR_LOCATION = 0;
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
            cars.add(new Car(name, INIT_CAR_LOCATION));
        }
        return cars;
    }
}

