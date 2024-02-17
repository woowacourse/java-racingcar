package racingcar.controller;

import racingcar.domain.*;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = repeat(this::inputCarNames);
        Round round = repeat(this::inputRound);
        CarRacingGame carRacingGame = new CarRacingGame(cars, round);

        race(carRacingGame);
        showWinners(carRacingGame.findWinners());
    }

    private Cars inputCarNames() {
        String inputCarNames = inputView.inputCarNames();
        return new Cars(inputCarNames);
    }

    private Round inputRound() {
        String inputRound = inputView.inputRound();
        return new Round(inputRound);
    }

    private void race(CarRacingGame carRacingGame) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        outputView.printResultMessage();
        while (!carRacingGame.isGameEnd()) {
            carRacingGame.playRound(numberGenerator);
            showRoundResult(carRacingGame);
        }
    }

    private void showRoundResult(CarRacingGame carRacingGame) {
        List<Car> currentCarStatuses = carRacingGame.getCurrentCarStatuses();
        List<CarDto> cars = new CarsDto(currentCarStatuses).getCars();

        outputView.printRoundResult(cars);
    }

    private void showWinners(List<Car> winners) {
        List<CarDto> winnersDto = new CarsDto(winners).getCars();

        outputView.printWinners(winnersDto);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return repeat(inputReader);
        }
    }
}
