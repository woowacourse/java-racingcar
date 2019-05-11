package racinggame.controller;

import racinggame.domain.Car;
import racinggame.util.InputView;
import racinggame.util.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceReady {

    public static List<Car> getCars() {
        try {
            List<String> carNames = InputView.getCarNames();
            return carNames.stream().map(Car::new).collect(Collectors.toList());
        } catch (Exception e) {
            OutputView.showErrorMessage(e.getMessage());
            return getCars();
        }
    }

    public static int getTotalTrial() {
        try {
            return InputView.getTrial();
        } catch (Exception e) {
            OutputView.showErrorMessage(e.getMessage());
            return getTotalTrial();
        }
    }
}
