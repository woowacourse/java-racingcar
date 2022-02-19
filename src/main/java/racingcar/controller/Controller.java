package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.generator.NameGenerator;
import racingcar.utils.generator.TrialNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private Cars cars;
    private int trialNumber;

    public void run() {
        initialize();
        OutputView.printResultMessage();
        forwardCarsByTrialNumber();
        OutputView.printWinners(cars.findWinnerNames());
    }

    private void initialize() {
        cars = new Cars(getCars());
        trialNumber = getTrialNumber();
    }

    private void forwardCarsByTrialNumber() {
        for (int i = 0; i < trialNumber; i++) {
            forwardCars();
            OutputView.printCarsPosition(cars.getCars());
        }
    }

    private void forwardCars() {
        cars.forward();
    }

    private List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        try {
            List<String> carNames = NameGenerator.generateCarNames(InputView.getCarNames());
            addNewCarToCars(cars, carNames);
            return cars;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getCars();
        }
    }

    private void addNewCarToCars(List<Car> cars, List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private int getTrialNumber() {
        String input = InputView.getTrialNumber();
        try {
            return TrialNumberGenerator.generateTrialNumber(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getTrialNumber();
        }
    }
}
