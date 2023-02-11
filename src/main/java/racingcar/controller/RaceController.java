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
        Cars cars = createCars();
        Race race = createRace();

        List<CarRaceDto> initCarsStatus = cars.initStatus();
        List<RaceResultDto> totalRaceResult = race.getRaceResult(cars);
        outputView.printRaceResult(initCarsStatus, totalRaceResult);

        List<String> winners = cars.pickWinners();
        outputView.printWinnerResult(winners);
    }

    private Cars createCars() {
        return inputUtil.getUserInput(() -> {
            String carNames = inputUtil.getCarNames();
            return Cars.of(carNames, numberGenerator);
        });
    }

    private Race createRace() {
        return inputUtil.getUserInput(() -> {
            String tryCount = inputUtil.getTryCount();
            return Race.of(tryCount);
        });
    }
}
