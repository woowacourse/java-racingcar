package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceNumberGenerator;
import racingcar.domain.dto.CarRaceDto;
import racingcar.domain.dto.RaceResultDto;
import racingcar.util.InputUtil;
import racingcar.view.OutputView;

import java.util.List;

public class CarRaceController implements Controller {

    private final InputUtil inputUtil = new InputUtil();

    private final OutputView outputView = new OutputView();

    private final RaceNumberGenerator numberGenerator = new RaceNumberGenerator();

    @Override
    public void process() {
        Cars cars = getUserInputAndCreateCars();
        Race race = getUserInputAndCreateRace();

        List<CarRaceDto> initCarResult = cars.initStatus();
        List<RaceResultDto> totalRaceResult = race.getRaceResults(cars);
        outputView.printRaceResult(initCarResult, totalRaceResult);

        List<String> winners = cars.pickWinners();
        outputView.printWinnersResult(winners);
    }

    private Cars getUserInputAndCreateCars() {
        return inputUtil.getUserInput(() -> {
            String carNames = inputUtil.getCarNames();
            return Cars.of(carNames, numberGenerator);
        });
    }

    private Race getUserInputAndCreateRace() {
        return inputUtil.getUserInput(() -> {
            String tryCount = inputUtil.getTryCount();
            return Race.of(tryCount);
        });
    }
}
