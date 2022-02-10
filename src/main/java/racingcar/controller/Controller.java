package racingcar.controller;

import racingcar.model.Car;
import racingcar.utils.RandomForwardJudgment;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final List<Car> cars = getCars();
    private final int trialNumber = getTrialNumber();

    public void run() {
        play();
    }

    private void play() {
        for (int i = 0; i < trialNumber; i++) {
            forwardCars();
        }
    }

    private void forwardCars() {
        for (Car car : cars) {
            car.forward(RandomForwardJudgment.canForward());
        }
    }

    private List<Car> getCars() {
        List<String> carNames = InputView.getCarNames();
        List<Car> cars = new ArrayList<>();

        carNames.forEach(carName -> cars.add(new Car(carName)));
        return cars;
    }

    private int getTrialNumber() {
        return InputView.getTrialNumber();
    }
}
