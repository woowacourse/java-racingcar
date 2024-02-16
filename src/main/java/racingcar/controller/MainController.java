package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarRacingGame;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.CarDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MainController {

    public void run() {
        CarRacingGame carRacingGame = repeat(this::initializeCarRacingGame);

        race(carRacingGame);
        showWinners(carRacingGame.findWinners());
    }

    private CarRacingGame initializeCarRacingGame() {
        String inputCarNames = InputView.inputCarNames();
        String inputRound = InputView.inputRound();

        return new CarRacingGame(inputCarNames, inputRound);
    }

    private void race(CarRacingGame carRacingGame) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        OutputView.printResultMessage();
        while (!carRacingGame.isGameEnd()) {
            carRacingGame.playRound(numberGenerator);
            showRoundResult(carRacingGame);
        }
    }

    private void showRoundResult(CarRacingGame carRacingGame) {
        List<Car> roundResult = carRacingGame.getRoundResult();
        List<CarDto> roundResultDto = toDto(roundResult);

        OutputView.printRoundResult(roundResultDto);
    }

    private void showWinners(List<Car> winners) {
        List<CarDto> winnersDto = toDto(winners);

        OutputView.printWinners(winnersDto);
    }

    private List<CarDto> toDto(List<Car> roundResult) {
        return roundResult.stream()
                .map(CarDto::new)
                .toList();
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
