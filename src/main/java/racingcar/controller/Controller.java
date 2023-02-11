package racingcar.controller;

import java.util.List;
import java.util.Map;

import racingcar.service.Service;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.ViewRenderer;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final ViewRenderer viewRenderer;
    private final Service service;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.viewRenderer = new ViewRenderer();
        this.service = new Service();
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
        service.makeCars(carNames);
    }

    private void setupNumberOfRounds() {
        outputView.printAskingInputNumberOfRounds();
        int numberOfRounds = inputView.inputNumberOfRounds();
        service.setNumberOfRounds(numberOfRounds);
    }

    private void printWinners() {
        List<String> winners = service.getWinners();
        outputView.printWinners(viewRenderer.renderWinners(winners));
    }

    private void play() {
        outputView.printResultStartingMessage();
        while (!service.isEnd()) {
            playEachRound();
        }
    }

    private void playEachRound() {
        service.playRound();
        Map<String, Integer> roundResult = service.getCurrentRoundResult();
        outputView.printResult(viewRenderer.renderRoundResult(roundResult));
    }
}
