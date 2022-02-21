package racingcar;

import racingcar.controller.CarController;
import racingcar.utils.Splitter;
import racingcar.view.ResultView;

import static racingcar.view.InputView.getCarNames;
import static racingcar.view.InputView.getIterationNo;

public class ApplicationMain {
    public static void main(String[] args) {
        CarController carController = new CarController();
        createCars(carController);
        carController.moveCars(getIterationNo());
        ResultView.printGameResult(carController.findGameScoreBoard());
        ResultView.printWinners(carController.findWinners());
    }

    private static void createCars(CarController carController) {
        try {
            carController.createCars(Splitter.split(getCarNames()));
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getMessage());
            createCars(carController);
        }
    }
}
