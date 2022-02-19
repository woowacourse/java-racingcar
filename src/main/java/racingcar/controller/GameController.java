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
        final List<String> carNames = inputView.requestCarNames();
        gameService.initCarNames(carNames);
    }

    private void initRound() {
        final int roundCount = inputView.requestRoundCount();
        gameService.initRound(roundCount);
    }

    public void playGame() {
        announceStatusTitle();
        announcePlayStatuses();
        announceWinners();
    }

    private void announceStatusTitle() {
        outputView.printMessageOfStatusTitle();
    }

    private void announcePlayStatuses() {
        while (gameService.isContinuable()) {
            gameService.playRound();
            outputView.printCarStatuses(gameService.getCurrentStatuses());
        }
    }

    private void announceWinners() {
        final List<String> winnerNames = gameService.getWinnerNames();
        outputView.printMessageOfWinners(winnerNames);
    }

}
