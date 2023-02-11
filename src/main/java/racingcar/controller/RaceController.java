package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.util.InputUtil;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController implements Controller {

    private final InputUtil inputUtil = new InputUtil();

    @Override
    public void process() {
        List<String> carNames = inputUtil.getUserInput(inputUtil::getCarNames);
        int tryCount = inputUtil.getUserInput(inputUtil::getTryCount);
        Race race = Race.of(carNames, tryCount);
        OutputView.printHeadResult(race.setUpGame());
        playGame(race);
    }

    private void playGame(Race race) {
        for (int i = 0; i < race.getTryCount(); i++) {
            OutputView.printRoundResult(race.playRound());
        }
        OutputView.printFinalResult(race.findWinnersName());
    }
}
