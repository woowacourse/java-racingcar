package controller;

import domain.Cars;
import domain.Count;
import domain.RacingGame;
import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
import domain.TurnResult;
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
        CarNameRequest carsNameRequest = retryUntillNoException(inputView::readCars);
        Count count = Count.from(retryUntillNoException(inputView::readCount));
        Cars cars = retryUntillNoException(Cars::fromDto, carsNameRequest);
        RacingGame racingGame = RacingGame.of(count, cars,
                new RandomMovementGenerator(new RandomNumberGenerator())); //TODO: 차차
        outputView.showStatusMessage();
        play(racingGame);
        Winners winners = Winners.from(cars);
        outputView.showResult(new WinnersResponse(winners));
    }

    public void play(RacingGame racingGame) {
        List<TurnResult> result = racingGame.getTurnResult();
        outputView.showStatus(result);
    }


    private <T> T retryUntillNoException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryUntillNoException(supplier);
        }
    }

    private <T, R> R retryUntillNoException(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryUntillNoException(function, input);
        }
    }
}
