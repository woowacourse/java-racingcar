package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceNumberGenerator;
import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.dto.RaceResultDto;
import racingcar.service.CarsService;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.enumType.InputMessage.GET_CAR_NAMES_MESSAGE;
import static racingcar.enumType.InputMessage.GET_TRY_COUNT_MESSAGE;

public class CarRaceController {

    private final InputView inputView;

    private final OutputView outputView;

    private final CarsService carsService;

    private final RaceService raceService;

    private final RaceNumberGenerator numberGenerator;

    public CarRaceController() {
        inputView = new InputView();
        outputView = new OutputView();
        carsService = new CarsService();
        raceService = new RaceService(carsService);
        numberGenerator = new RaceNumberGenerator();
    }

    public void race() {
        Cars cars = getUserInputAndCreateCars();
        Race race = getUserInputAndCreateRace();
        getRaceResult(cars, race);
        getWinnerResult(cars);
    }

    private Cars getUserInputAndCreateCars() {
        return inputView.getUserInput(() -> {
            OutputView.printMessage(GET_CAR_NAMES_MESSAGE.getValue());
            String carNames = inputView.readConsole();
            return carsService.createCars(carNames, numberGenerator);
        });
    }

    private Race getUserInputAndCreateRace() {
        return inputView.getUserInput(() -> {
            OutputView.printMessage(GET_TRY_COUNT_MESSAGE.getValue());
            String tryCount = inputView.readConsole();
            return raceService.createRace(tryCount);
        });
    }

    private void getRaceResult(final Cars cars, final Race race) {
        List<CarStatusDto> initCarStatus = carsService.getCarStatus(cars);
        List<RaceResultDto> totalRaceResult = raceService.getRaceResults(cars, race);
        outputView.printRaceResult(initCarStatus, totalRaceResult);
    }

    private void getWinnerResult(final Cars cars) {
        List<String> winners = carsService.pickWinners(cars);
        outputView.printWinnersResult(winners);
    }
}
