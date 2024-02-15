package controller;

import java.util.List;
import model.Cars;
import model.Racing;
import model.dto.CarState;
import view.InputView;
import view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = prepareCars();
        Racing racing = prepareRacing();
        play(racing, cars);
        end(racing, cars);
    }

    public Cars prepareCars() {
        List<String> carNames = inputView.askCarNames();
        return Cars.fromNames(carNames);
    }

    public Racing prepareRacing() {
        int tryCount = inputView.askTryCount();
        return new Racing(tryCount);
    }

    public void play(Racing racing, Cars cars) {
        outputView.printPlayResult();
        while (racing.canTry()) {
            racing.doTry(cars);
            List<CarState> carStates = cars.captureCarStates();
            outputView.printCapturedCarStates(carStates);
        }
    }

    public void end(Racing racing, Cars cars) {
        List<String> winners = racing.determineWinner(cars);
        outputView.printFinalResult(winners);
    }
}
