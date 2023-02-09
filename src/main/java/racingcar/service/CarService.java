package racingcar.service;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarService {
    public void initializeService() {
        OutputView.printNameInput();
        String carNames = InputView.readCarNames();
    }
}
