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
    private static final String NO_NAME_ERROR = "자동차 이름은 없을 수 없습니다.";
    private static final String COMMA = ",";

    private Cars cars;
    private AttemptNumber attemptNumber;

    public void play() {
        init();
        OutputView.printNextLine();
        OutputView.printExecutionResultMessage();
        Random random = new Random();
        for (int i = 0; i < attemptNumber.getAttemptNumber(); i++) {
            cars.move(random);
            OutputView.printCarStateMessage(cars);
        }
        OutputView.printWinnerCarNamesMessage(cars.getWinners());
    }

    private void init() {
        List<Car> carList = new ArrayList<>();
        OutputView.printInputCarNamesMessage();
        String carNames = InputView.getCarNames();
        String[] carNamesArray = carNamesSplit(carNames);
        for (String carName : carNamesArray) {
            carList.add(new Car(carName));
        }
        cars = new Cars(carList);
        OutputView.printInputAttemptNumberMessage();
        attemptNumber = new AttemptNumber(InputView.getAttemptNumber());
    }

    private String[] carNamesSplit(String carNames) {
        String[] carNamesArray = carNames.split(COMMA);
        if (carNamesArray.length == 0) {
            throw new IllegalArgumentException(NO_NAME_ERROR);
        }
        return carNamesArray;
    }
}