package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.Movement;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingController {
    private final OutputView outputView;
    private final Movement movement;

    private final Cars cars;
    private int trialCount;

    public RacingController(final InputView inputView, final OutputView outputView, final Movement movement) {
        cars = new Cars(inputView.inputCarNames());
        trialCount = inputView.inputTrialCount();
        this.outputView = outputView;
        this.movement = movement;
    }

    public void run() {
        outputView.printResultMessage();
        while (trialCount > 0) {
            cars.move(movement);
            outputView.printRoundStatus(cars.getCarInfos());
            trialCount--;
        }
        outputView.printWinners(cars.getFarthestCar());
    }
}
