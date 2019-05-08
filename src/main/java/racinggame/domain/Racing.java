package racinggame.domain;


import racinggame.util.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final int RANDOM_BOUND = 10;

    public List<Car> initializeCars() {
        List<String> carNames = InputView.getCarNames();
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void startLeague(List<Car> cars, int totalTrial) {
        for (int trial = 1; trial <= totalTrial; trial++) {

        }
    }

    int generateRandomNumber() {
        Random random = new Random();

        return random.nextInt(RANDOM_BOUND);
    }

    public static void main(String[] args) {
        Racing racing = new Racing();
        List<Car> cars = racing.initializeCars();
        int totalTrial = InputView.getTrial();

        racing.startLeague(cars, totalTrial);
    }
}
