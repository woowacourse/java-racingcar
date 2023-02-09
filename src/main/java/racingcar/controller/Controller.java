package racingcar.controller;

import racingcar.service.Service;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.ViewRenderer;

import java.util.List;
import java.util.Map;

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
        outputView.printAskingInputCarNames();
        String carNames = inputView.inputCarNames();
        service.makeCars(carNames);

        outputView.printAskingInputNumberOfRounds();
        int numberOfRounds = inputView.inputNumberOfRounds();
        service.setNumberOfRounds(numberOfRounds);

        outputView.printResultStartingMessage();
        while (!service.isEnd()) {
            service.playRound();
            Map<String, Integer> roundResult = service.getCurrentRoundResult();
            outputView.printResult(viewRenderer.renderRoundResult(roundResult));
        }

        List<String> winners = service.getWinners();
        outputView.printWinners(viewRenderer.renderWinners(winners));
    }

}
