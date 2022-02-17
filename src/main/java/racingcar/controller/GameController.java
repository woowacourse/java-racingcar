package racingcar.controller;

import java.util.List;

import racingcar.service.GameService;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public GameController(final GameService gameService, final InputView inputView, final OutputView outputView) {
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void initGame() {
        initParticipants();
        initRound();
    }

    private void initParticipants() {
        gameService.initCarNames(requestCarNames());
    }

    private List<String> requestCarNames() {
        outputView.printMessageOfRequestCarNames();
        return inputView.requestCarNames();
    }

    private void initRound() {
        gameService.initRound(requestRound());
    }

    private int requestRound() {
        outputView.printMessageOfRequestRound();
        return inputView.requestRoundNumber();
    }

    public void playGame() {
        announceStatusTitle();
        announcePlayStatuses();
        announceWinners();
    }

    private void announceStatusTitle() {
        outputView.printEmptyLine();
        outputView.printMessageOfStatusTitle();
    }

    private void announcePlayStatuses() {
        while (gameService.isContinuable()) {
            gameService.playRound();
            announceStatuses(gameService.getCurrentStatuses());
        }
    }

    private void announceStatuses(final List<String> carStatuses) {
        outputView.printCarStatuses(carStatuses);
        outputView.printEmptyLine();
    }

    private void announceWinners() {
        final List<String> winnerNames = gameService.getWinnerNames();
        outputView.printMessageOfWinners(winnerNames);
    }

}
