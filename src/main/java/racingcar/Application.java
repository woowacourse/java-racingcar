package racingcar;

import racingcar.controller.Controller;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Cars cars = getCars();
        int trialNumber = getTrialNumber();
        OutputView.printResultMessage();
        controller.run(cars, trialNumber);
    }

    private static Cars getCars() {
        try {
            return new Cars(InputView.getCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getCars();
        }
    }

    private static int getTrialNumber() {
        try {
            return InputView.getTrialNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getTrialNumber();
        }
    }
}
