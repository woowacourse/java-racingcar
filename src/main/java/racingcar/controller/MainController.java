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
        Cars cars = repeat(this::getInputAndCreateCars);
        Round round = repeat(this::getInputAndCreateRound);
        CarRacingGame carRacingGame = new CarRacingGame(cars, round);

        OutputView.printResultMessage();
        List<CarsDto> raceResult = carRacingGame.race();
        OutputView.printRaceResult(raceResult);

        showWinners(carRacingGame.findWinners());
    }

    private Cars getInputAndCreateCars() {
        String inputCarNames = InputView.inputCarNames();
        return new Cars(inputCarNames);
    }

    private Round getInputAndCreateRound() {
        String inputRound = InputView.inputRound();
        return new Round(inputRound);
    }

    private void showWinners(List<Car> winners) {
        List<CarDto> winnersDto = new CarsDto(winners).getCars();

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
