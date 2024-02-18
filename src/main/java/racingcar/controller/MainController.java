package racingcar.controller;

import racingcar.domain.*;
import racingcar.dto.CarDto;
import racingcar.utils.Converter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MainController {

    public void run() {
        CarRacingGame carRacingGame = repeat(this::initializeCarRacingGame);
        List<RoundResult> roundResults = carRacingGame.race();

        showRoundResults(roundResults);
        showWinners(carRacingGame.findWinners());
    }

    private CarRacingGame initializeCarRacingGame() {
        String inputCarNames = InputView.inputCarNames();
        List<String> carNames = Converter.convert(inputCarNames);
        Cars cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::new));

        int inputRound = InputView.inputRound();
        Round round = new Round(inputRound);

        return new CarRacingGame(cars, round);
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
