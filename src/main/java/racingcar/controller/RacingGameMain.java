package racingcar.controller;

import racingcar.domain.GameCount;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGamePlayers;
import racingcar.domain.result.RacingGameResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameMain {
    public static void main(String[] args) {
        RacingGamePlayers players = new RacingGamePlayers(InputView.getCars());
        GameCount gameCount = InputView.getGameCount();
        RacingGameResult racingGameResult = new RacingGame(players, gameCount).start();
        OutputView.showRacingGameProcess(racingGameResult);
        OutputView.showWinners(racingGameResult);
    }
}
