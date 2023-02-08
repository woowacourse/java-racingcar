package controller;

import model.Racing;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void racingStart() {
        List<String> carNames = inputView.carNames();
        Racing racing = new Racing(carNames);
        int numberOfTimes = inputView.numberOfTimes();
        process(racing, numberOfTimes);
        end(racing);
    }

    private void process(Racing racing, int numberOfTimes) {
        outputView.result();

        for (int i = 0; i < numberOfTimes; i++) {
            racing.moveAll();
            outputView.makeResult(racing);
        }
    }

    private void end(Racing racing) {
        outputView.winner(racing.winner());
    }
}
