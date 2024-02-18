package controller;

import domain.AttemptCount;
import domain.RandomMovingCar;
import domain.RandomMovingCars;
import domain.Winners;
import domain.car.Car;
import util.ExceptionRetryHandler;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RandomMovingCars randomMovingCars = ExceptionRetryHandler.handle(this::receiveCarNames);
        AttemptCount attemptCount = ExceptionRetryHandler.handle(this::receiveTryCount);
        racing(randomMovingCars, attemptCount);
        outputView.printWinners(Winners.from(randomMovingCars));
    }

    private RandomMovingCars receiveCarNames() {
        List<String> carNames = inputView.readCarNames();

        return new RandomMovingCars(carNames.stream()
                .map(Car::createOnStart)
                .map(car -> new RandomMovingCar(car, RandomMovingCar::generateRandomPower))
                .toList());
    }

    private AttemptCount receiveTryCount() {
        return new AttemptCount(inputView.readTryCount());
    }

    private void racing(RandomMovingCars randomMovingCars, AttemptCount attemptCount) {
        outputView.printRacingResult();

        while (attemptCount.remainCount()) {
            attemptCount.attempt();
            randomMovingCars.moveAll();
            outputView.printRacingProceed(randomMovingCars);
        }
    }
}
