package racingCar.controller;

import racingCar.domain.RacingGame;
import racingCar.dto.CarDto;
import racingCar.util.NumberGenerator;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class RacingCarController {

    public void run(NumberGenerator numberGenerator) {
        RacingGame racingGame = repeat(this::initializeGame);
        playRacing(numberGenerator, racingGame);
        OutputView.printWinners(racingGame.findWinners());
    }

    private RacingGame initializeGame() {
        List<String> carNames = repeat(InputView::readCarNames);
        int tryCount = repeat(InputView::readTryCount);
        return new RacingGame(carNames, tryCount);
    }

    private void playRacing(NumberGenerator numberGenerator, RacingGame game) {
        while (game.isPlayable()) {
            List<CarDto> carStatuses = game.play(numberGenerator);
            OutputView.printCarPosition(carStatuses);
        }
    }

    private <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
            return repeat(reader);
        }
    }
}
