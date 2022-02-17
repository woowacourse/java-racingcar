package racingcargame.controller;

import java.util.List;

import racingcargame.model.RacingCarGame;
import racingcargame.utils.RandomNumberGenerator;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class GameController {
    final InputView inputView;
    final OutputView outputView;

    final RandomNumberGenerator randomNumberGenerator;

    public GameController(final InputView inputView, final OutputView outputView,
                          final RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;

        this.randomNumberGenerator = randomNumberGenerator;
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
        while (racingCarGame.isNotOverRace()) {
            racingCarGame.startRace();
            outputView.showCurrentRaceStatus(racingCarGame.sendRacingCarsInformation());
        }
    }

    private void finishGame(final RacingCarGame racingCarGame) {
        outputView.showWinners(racingCarGame.sendRacingGameWinner());
    }
}
