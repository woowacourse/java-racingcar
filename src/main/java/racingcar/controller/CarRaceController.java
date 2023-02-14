package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceNumberGenerator;
import racingcar.domain.WinnerCar;
import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.dto.RaceResultDto;
import racingcar.service.CarsService;
import racingcar.service.RaceService;
import racingcar.service.WinnerCarService;
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

    private final WinnerCarService winnerCarService;

    private final RaceNumberGenerator numberGenerator;

    public CarRaceController() {
        inputView = new InputView();
        outputView = new OutputView();
        carsService = new CarsService();
        raceService = new RaceService(carsService);
        winnerCarService = new WinnerCarService();
        numberGenerator = new RaceNumberGenerator();
    }

    public void race() {
        String carNames = getCarNames();
        Cars cars = createCars(carNames);
        String tryCount = getTryCount();
        Race race = createRace(tryCount);

        printInitCarStatus(cars);
        printRaceResult(cars, race);
        printWinnerResult(cars);
    }

    private String getCarNames() {
        return inputView.getUserInput(() -> {
            OutputView.printMessage(GET_CAR_NAMES_MESSAGE.getValue());
            return inputView.readConsole();
        });
    }

    private Cars createCars(String carNames) {
        return carsService.createCars(carNames, numberGenerator);
    }

    private String getTryCount() {
        return inputView.getUserInput(() -> {
            OutputView.printMessage(GET_TRY_COUNT_MESSAGE.getValue());
            return inputView.readConsole();
        });
    }

    private Race createRace(String tryCount) {
        return raceService.createRace(tryCount);
    }

    private void printInitCarStatus(Cars cars) {
        List<CarStatusDto> initCarStatus = carsService.getCarStatus(cars);
        outputView.printInitCarStatus(initCarStatus);
    }

    private void printRaceResult(final Cars cars, final Race race) {
        List<RaceResultDto> totalRaceResult = raceService.getRaceResults(cars, race);
        outputView.printRaceResult(totalRaceResult);
    }

    private void printWinnerResult(final Cars cars) {
        WinnerCar winnerCar = winnerCarService.createWinnerCar(cars);
        List<String> winners = winnerCarService.getWinnerNames(winnerCar);
        outputView.printWinnersResult(winners);
    }
}
