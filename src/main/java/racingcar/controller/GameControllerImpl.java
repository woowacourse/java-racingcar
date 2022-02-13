package racingcar.controller;

import java.util.List;

import racingcar.service.GameService;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class GameControllerImpl implements GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public GameControllerImpl(GameService gameService, InputView inputView, OutputView outputView) {
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

    private void announceStatuses(List<String> carStatuses) {
        outputView.printCarStatuses(carStatuses);
        outputView.printEmptyLine();
    }

    private void announceWinners() {
        List<String> winnerNames = gameService.getWinnerNames();
        outputView.printMessageOfWinners(winnerNames);
    }

}
