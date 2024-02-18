package controller;

import domain.Cars;
import domain.Count;
import domain.MovementGenerator;
import domain.NumberGenerator;
import domain.RacingGame;
import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
import domain.Winners;
import dto.CarNameRequest;
import dto.CarsReponse;
import dto.WinnersResponse;
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
        Cars cars = getCars();
        Count count = Count.from(retryUntilNoException(inputView::readCount));

        RacingGame racingGame = RacingGame.of(count, createRandomMovementGenerator());

        outputView.showStatusMessage();
        play(racingGame, cars);

        Winners winners = Winners.from(cars);
        outputView.showWinners(new WinnersResponse(winners));
    }

    private Cars getCars() {
        CarNameRequest carsNameRequest = retryUntilNoException(inputView::readCars);
        return retryUntilNoException(carsNameRequest::toCars);
    }

    private static MovementGenerator createRandomMovementGenerator() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        return new RandomMovementGenerator(numberGenerator);
    }

    public void play(RacingGame racingGame, Cars cars) {
        while (racingGame.canRun()) {
            racingGame.playTurn(cars);
            outputView.showTurnResult(CarsReponse.from(cars));
        }
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
