package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.Movement;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final OutputView outputView;
    private final Movement movement;

    private final Cars cars;
    private int trialCount;

    public RacingController(InputView inputView, OutputView outputView, Movement movement) {
        cars = new Cars(inputView.inputCarNames());
        trialCount = inputView.inputTrialCount();
        this.outputView = outputView;
        this.movement = movement;
    }

    public void run() {
        outputView.printResultMessage();
        while(trialCount > 0) {
            cars.move(movement);
            outputView.printRoundStatus(cars.getCarInfos());
            trialCount--;
        }
        outputView.printWinners(cars.getFarthestCar());
    }
}
