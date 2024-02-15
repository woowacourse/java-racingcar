package controller;

import domain.Car;
import domain.CarStatusResponse;
import domain.Cars;
import domain.RacingGame;
import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
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
        Cars cars = Cars.fromDto(carsNameRequest);
        RacingGame racingGame = RacingGame.of(count, cars,
                new RandomMovementGenerator(new RandomNumberGenerator())); //TODO: 차차
        outputView.showStatusMessage();
        play(racingGame);
        Winners winners = Winners.from(cars);
        outputView.showResult(new WinnersResponse(winners));
    }

    public void play(RacingGame racingGame) {
        List<List<CarStatusResponse>> result = racingGame.getTurnResult();
        outputView.showStatus(result);
    }
}
