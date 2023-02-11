package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceNumberGenerator;
import racingcar.domain.dto.CarRaceDto;
import racingcar.domain.dto.RaceResultDto;
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

        List<CarRaceDto> carRaceResult = cars.initStatus();
        List<RaceResultDto> totalRaceResult = race.start(cars);

        outputView.printRaceResult(carRaceResult, totalRaceResult);

        List<String> winners = cars.pickWinners();
        outputView.printWinnerResult(winners);
    }
}
