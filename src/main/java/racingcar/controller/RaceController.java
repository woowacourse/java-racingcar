package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.util.InputUtil;
import racingcar.view.OutputView;

public class RaceController implements Controller {

    private final InputUtil inputUtil = new InputUtil();

    @Override
    public void process() {
        Cars cars = inputUtil.getUserInput(inputUtil::getCarNames);
        Race race = inputUtil.getUserInput(inputUtil::getTryCount);
        OutputView.printHeadResult(cars);
        OutputView.printMessage(race.start(cars).trim());
        String winners = cars.pickWinners();
        OutputView.printFinalResult(winners);
    }
}
