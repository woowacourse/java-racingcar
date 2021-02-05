package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.domain.AttemptNumber;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private Cars cars;
    private AttemptNumber attemptNumber;

    public CarController() {
    }

    private void init() {
        List<Car> carList = new ArrayList<>();
        OutputView.printInputCarNamesMessage();
        String carNames = InputView.getCarNames();
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            carList.add(new Car(carName));
        }
        cars = new Cars(carList);
        OutputView.printInputAttemptNumberMessage();
        attemptNumber = new AttemptNumber(InputView.getAttemptNumber());
    }

    public void play() {
        init();
        OutputView.printNextLine();
        OutputView.printExecutionResultMessage();
        Random random = new Random();
        for (int i = 0; i < attemptNumber.getAttemptNumber(); i++) {
            cars.move(random);
        }
        OutputView.printWinnerCarNamesMessage(cars.getWinners());
    }
}