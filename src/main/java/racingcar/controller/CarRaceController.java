package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceNumberGenerator;
import racingcar.domain.dto.CarRaceDto;
import racingcar.domain.dto.RaceResultDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.enumType.InputMessage.GET_CAR_NAMES_MESSAGE;
import static racingcar.enumType.InputMessage.GET_TRY_COUNT_MESSAGE;

public class CarRaceController {

    private final InputView inputView;

    private final OutputView outputView;

    private final RaceNumberGenerator numberGenerator;

    public CarRaceController() {
        inputView = new InputView();
        outputView = new OutputView();
        numberGenerator = new RaceNumberGenerator();
    }

    public void race() {
        Cars cars = getUserInputAndCreateCars();
        Race race = getUserInputAndCreateRace();

        List<CarRaceDto> initCarResult = cars.initStatus();
        List<RaceResultDto> totalRaceResult = race.getRaceResults(cars);
        outputView.printRaceResult(initCarResult, totalRaceResult);

        List<String> winners = cars.pickWinners();
        outputView.printWinnersResult(winners);
    }

    private Cars getUserInputAndCreateCars() {
        return inputView.getUserInput(() -> {
            OutputView.printMessage(GET_CAR_NAMES_MESSAGE.getValue());
            String carNames = inputView.readConsole();
            return Cars.createCars(carNames, numberGenerator);
        });
    }

    private Race getUserInputAndCreateRace() {
        return inputView.getUserInput(() -> {
            OutputView.printMessage(GET_TRY_COUNT_MESSAGE.getValue());
            String tryCount = inputView.readConsole();
            return Race.createRace(tryCount);
        });
    }
}
