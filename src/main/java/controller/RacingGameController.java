package controller;

import domain.Cars;
import domain.Count;
import domain.RacingGame;
import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
import dto.TurnResult;
import domain.Winners;
import dto.CarNameRequest;
import dto.WinnersResponse;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class RacingGameController {


    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CarNameRequest carsNameRequest = retryUntilNoException(inputView::readCars);
        Count count = Count.from(retryUntilNoException(inputView::readCount));
        Cars cars = retryUntilNoException(Cars::fromDto, carsNameRequest);
        RacingGame racingGame = RacingGame.of(count, cars, new RandomMovementGenerator(new RandomNumberGenerator()));
        outputView.showStatusMessage();
        outputView.showStatus(racingGame.getGameResult());
        outputView.showResult(new WinnersResponse(cars.getWinners()));
    }


    private <T> T retryUntilNoException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryUntilNoException(supplier);
        }
    }

    private <T, R> R retryUntilNoException(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryUntilNoException(function, input);
        }
    }
}
