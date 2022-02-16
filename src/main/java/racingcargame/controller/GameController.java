package racingcargame.controller;

import java.util.List;

import racingcargame.model.RacingCarGame;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class GameController {
    final InputView inputView;
    final OutputView outputView;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runGame() {
        final RacingCarGame racingCarGame = setUpGame();

        playGame(racingCarGame);

        finishGame(racingCarGame);
    }

    private RacingCarGame setUpGame() {
        List<String> racingCarNames = inputView.inputRacingCarNames();
        String raceCount = inputView.inputRaceCount();
        return new RacingCarGame(racingCarNames, raceCount);
    }

    private void playGame(final RacingCarGame racingCarGame) {
        outputView.showRaceResultMessage();
        while (!racingCarGame.isOverRace()) {
            racingCarGame.startRace();
            outputView.showCurrentRaceStatus(racingCarGame.sendCurrentPositionOfRacingCars());
        }
    }

    private void finishGame(final RacingCarGame racingCarGame) {
        outputView.showWinners(racingCarGame.sendRacingGameWinner());
    }
}
