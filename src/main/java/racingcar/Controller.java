package racingcar;

import java.util.List;

public class Controller {
    final InputView inputView = new InputView();
    final InputValidator inputValidator = new InputValidator();
    public void run() {
        List<String> carNames = inputView.getCarNames();
        inputValidator.validateAvailableCarNames(carNames);

    }
}
