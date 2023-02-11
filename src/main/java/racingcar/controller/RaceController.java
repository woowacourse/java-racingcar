package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceNumberGenerator;
import racingcar.util.InputUtil;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController implements Controller {

    private final InputUtil inputUtil = new InputUtil();

    private final OutputView outputView = new OutputView();

    private final RaceNumberGenerator numberGenerator = new RaceNumberGenerator();

    @Override
    public void process() {
        String carNames = inputUtil.getUserInput(inputUtil::getCarNames);
        Cars cars = Cars.of(carNames, numberGenerator);
        String tryCount = inputUtil.getUserInput(inputUtil::getTryCount);

        Race race = Race.of(tryCount);
        outputView.printRaceResult(cars, race);

        List<String> winners = cars.pickWinners();
        outputView.printWinnerResult(winners);
    }
}
