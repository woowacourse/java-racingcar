package racingcar;

import racingcar.controller.CarController;
import racingcar.utils.Splitter;
import racingcar.view.ResultView;

import static racingcar.view.InputView.getCarNames;
import static racingcar.view.InputView.getIterationNo;

public class ApplicationMain {
    public static void main(String[] args) {
        CarController carController = new CarController();
        carController.createCars(Splitter.split(getCarNames()));
        carController.moveCars(getIterationNo());
        ResultView.printGameResult(carController.findGameScoreBoard());
        ResultView.printWinners(carController.findWinners());
    }
}
