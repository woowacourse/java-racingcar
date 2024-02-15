package controller;

import domain.CarStatusResponse;
import domain.Cars;
import domain.RacingGame;
import domain.Winners;
import dto.CarNameRequest;
import dto.WinnersResponse;
import java.util.List;
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
        CarNameRequest carsNameRequest = inputView.readCars();
        int count = inputView.readCount();
        RacingGame racingGame = RacingGame.of(count, cars, new RandomMovementGenerator(new RandomNumberGenerator()));
        outputView.showStatusMessage();
        play(cars, count, racingGame);
        Winners winners = Winners.from(cars);
        outputView.showResult(new WinnersResponse(winners));
    }

    public void play(Cars cars, int count, RacingGame racingGame) {
        List<List<CarStatusResponse>> result = racingGame.getTurnResult();
        outputView.showStatus(result);
    }
}
