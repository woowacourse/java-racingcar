package racinggame.domain;


import racinggame.util.InputView;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public List<Car> initializeCars() {
        List<String> carNames = InputView.getCarNames();
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void startLeague(List<Car> cars, int trial) {

    }

    public static void main(String[] args) {
        Racing racing = new Racing();
        List<Car> cars = racing.initializeCars();
        int trial = InputView.getTrial();

        racing.startLeague(cars, trial);
    }
}
