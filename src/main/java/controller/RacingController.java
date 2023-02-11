package controller;

import model.Racing;
import model.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        inputView = new InputView(System.in);
        outputView = new OutputView();
    }

    public void racingStart() {
        List<String> carNames = inputView.inputCarNames();
        Racing racing = new Racing(carNames, new RandomNumberGenerator(new Random()));
        int numberOfTimes = inputView.inputRepeatCount();
        process(racing, numberOfTimes);
        end(racing);
    }

    private void process(Racing racing, int numberOfTimes) {
        outputView.resultHeader();
        IntStream.range(0, numberOfTimes).forEach(i -> eachProcess(racing));
    }

    private void eachProcess(Racing racing) {
        racing.moveAllCars();
        outputView.result(racing);
    }

    private void end(Racing racing) {
        outputView.winner(racing.winner());
    }
}
