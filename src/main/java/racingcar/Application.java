package racingcar;

import racingcar.controller.CarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    // psvm 쓰면 한방에 나온다
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();
        CarController carController = new CarController(carNames, tryNumber);
        while (!carController.isEnd()) {
            carController.play();
            OutputView.printCarStateMessage(carController.getCars());
        }
        OutputView.printWinnerCarNamesMessage(carController.getWinners());
    }
}
