package racingcargame.controller;

import java.util.List;

import racingcargame.model.RacingCarGame;
import racingcargame.utils.Move;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class GameController {
    final InputView inputView;
    final OutputView outputView;

    final Move move;

    public GameController(final InputView inputView, final OutputView outputView,
                          final Move move) {
        this.inputView = inputView;
        this.outputView = outputView;

        this.move = move;
    }

    public void runGame() {
        // 질문 드릴 부분
        final RacingCarGame racingCarGame = setUpGame();

        playGame(racingCarGame);

        finishGame(racingCarGame);
    }

    private RacingCarGame setUpGame() {
        final List<String> racingCarNames = inputView.inputRacingCarNames();
        final String raceCount = inputView.inputRaceCount();
        return new RacingCarGame(racingCarNames, raceCount);
    }

    private void playGame(final RacingCarGame racingCarGame) {
        outputView.showRaceResultMessage();
        while (racingCarGame.isNotOverRace()) {
            racingCarGame.startRace(move);
            outputView.showCurrentRaceResult(racingCarGame.sendRacingCarsInformation());
        }
    }

    private void finishGame(final RacingCarGame racingCarGame) {
        outputView.showRaceWinners(racingCarGame.sendRacingGameWinner());
    }
}
