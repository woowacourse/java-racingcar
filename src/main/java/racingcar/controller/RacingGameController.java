package racingcar.controller;

import racingcar.domain.*;
import racingcar.domain.Rule.MoveRule;
import racingcar.domain.Rule.Rule;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private RacingCars racingCars;
    private Rule rule;
    private int tryCount;

    public RacingGameController() {
        String[] carNames = CarNameSpliter.splitCarNames(InputView.inputCarList());

        tryCount = InputView.inputTryCount();
        racingCars = new RacingCars(carNames);
        rule = new MoveRule();
    }

    public void playRacingGame() {
        List<RacingCars> allResult = RacingGame.playRacingGame(racingCars, tryCount, rule);
        RacingCars lastResult = allResult.get(allResult.size() - 1);

        OutputView.outputAllTryCarPosition(allResult);
        OutputView.outputWinners(lastResult.findWinningCars());
    }
}