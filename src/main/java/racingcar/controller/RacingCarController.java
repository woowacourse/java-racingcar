package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.ViewRenderer;

import java.util.List;
import java.util.Map;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ViewRenderer viewRenderer;
    private final RacingCarService racingCarService;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.viewRenderer = new ViewRenderer();
        this.racingCarService = new RacingCarService();
    }

    public void run() {
        setupCars();
        setupNumberOfRounds();
        play();
        printWinners();
    }

    private void setupCars() {
        outputView.printAskingInputCarNames();
        String carNames = inputView.inputCarNames();
        racingCarService.makeCars(carNames);
    }

    private void setupNumberOfRounds() {
        outputView.printAskingInputNumberOfRounds();
        int numberOfRounds = inputView.inputNumberOfRounds();
        racingCarService.setNumberOfRounds(numberOfRounds);
    }

    private void printWinners() {
        List<String> winners = racingCarService.getWinners();
        outputView.printWinners(viewRenderer.renderWinners(winners));
    }

    private void play() {
        outputView.printResultStartingMessage();
        while (!racingCarService.isEnd()) {
            playEachRound();
        }
    }

    private void playEachRound() {
        racingCarService.playRound();
        Map<String, Integer> roundResult = racingCarService.getCurrentRoundResult();
        outputView.printResult(viewRenderer.renderRoundResult(roundResult));
    }

}
