package racingcar.controller;

import racingcar.domain.*;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MainController {
    public void run() {
        final Cars cars = repeat(this::getInputAndCreateCars);
        final Round round = repeat(this::getInputAndCreateRound);
        final CarRacingGame carRacingGame = new CarRacingGame(cars, round);

        OutputView.printResultMessage();
        final List<CarsDto> raceResult = carRacingGame.race();
        OutputView.printRaceResult(raceResult);

        showWinners(carRacingGame.findWinners());
    }

    private Cars getInputAndCreateCars() {
        final String inputCarNames = InputView.inputCarNames();
        return new Cars(inputCarNames);
    }

    private Round getInputAndCreateRound() {
        final String inputRound = InputView.inputRound();
        return new Round(inputRound);
    }

    private void showWinners(List<Car> winners) {
        final List<CarDto> winnersDto = new CarsDto(winners).getCars();

        OutputView.printWinners(winnersDto);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return repeat(inputReader);
        }
    }
}
