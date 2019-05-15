package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Play {
    private final Cars cars;

    public Play(String names) {
        cars = new Cars(names);
    }

    public Winners getWinners() {
        return new Winners(this.cars);
    }

    public List<String> moveCarState() {
        cars.updateCarMovement();
        return getCarStates();
    }

    public List<String> getCarStates() {
        List<String> carStates = new ArrayList<>();
        for (int i = 0, n = cars.getSize(); i < n; i++) {
            carStates.add(cars.getCarState(i));
        }
        return carStates;
    }
}
