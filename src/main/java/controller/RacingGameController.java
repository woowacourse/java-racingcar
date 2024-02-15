package controller;

import domain.Cars;
import domain.Count;
import domain.GameResult;
import domain.MovementGenerator;
import domain.RacingGame;
import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
import domain.Winners;
import dto.CarNameRequest;
import dto.WinnersResponse;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovementGenerator movementGenerator;

    public RacingGameController(InputView inputView, OutputView outputView, MovementGenerator movementGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movementGenerator = movementGenerator;
    }

    public void run() {
        Cars cars = getCars();
        Count count = Count.from(retryUntilNoException(inputView::readCount));
        RacingGame racingGame = RacingGame.of(count, cars, movementGenerator);

        outputView.showStatusMessage();
        play(racingGame);

        Winners winners = Winners.from(cars);
        outputView.showResult(new WinnersResponse(winners));
    }

    private Cars getCars() {
        CarNameRequest carsNameRequest = retryUntilNoException(inputView::readCars);
        return retryUntilNoException(carsNameRequest::toCars);
    }

    public void play(RacingGame racingGame) {
        GameResult result = racingGame.getGameResult();
        outputView.showStatus(result);
    }

    private <T> T retryUntilNoException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryUntilNoException(supplier);
        }
    }
}
