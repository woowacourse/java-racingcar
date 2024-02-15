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

    }

    public void prepare() {

    }

    public void play(int tryCount, Cars cars) {
        outputView.printPlayResult();
        Racing racing = new Racing(tryCount);
        while (racing.canTry()) {
            racing.doTry(cars);
            List<CarState> carStates = cars.captureCarStates();
            outputView.printCapturedCarStates(carStates);
        }
    }

    public void end(Racing racing, Cars cars) {

    }
}
