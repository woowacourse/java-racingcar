package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarRacingGame;
import racingcar.domain.RoundResult;
import racingcar.dto.CarDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MainController {

    public void run() {
        CarRacingGame carRacingGame = repeat(this::initializeCarRacingGame);
        List<RoundResult> roundResults = carRacingGame.race();

        showRoundResults(roundResults);
        showWinners(carRacingGame.findWinners());
    }

    private CarRacingGame initializeCarRacingGame() {
        String inputCarNames = InputView.inputCarNames();
        String inputRound = InputView.inputRound();

        return new CarRacingGame(inputCarNames, inputRound);
    }

    private void showRoundResults(List<RoundResult> roundResults) {
        OutputView.printResultMessage();

        roundResults.forEach(roundResult -> {
            OutputView.printRoundResult(roundResult.getRoundResult());
        });
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
