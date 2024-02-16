package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarRacingGame;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
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
        CarRacingGame carRacingGame = repeat(this::initializeCarRacingGame);

        race(carRacingGame);
        showWinners(carRacingGame.findWinners());
    }

    private CarRacingGame initializeCarRacingGame() {
        String inputCarNames = inputView.inputCarNames();
        String inputRound = inputView.inputRound();

        return new CarRacingGame(inputCarNames, inputRound);
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
