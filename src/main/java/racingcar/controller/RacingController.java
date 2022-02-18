package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.trialcount.TrialCount;
import racingcar.domain.movement.Movement;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingController {
    private final OutputView outputView;
    private final Movement movement;
    private final Cars cars;
    private final TrialCount trialCount;

    public RacingController(final InputView inputView, final OutputView outputView, final Movement movement) {
        cars = new Cars(inputView.inputCarNames());
        trialCount = new TrialCount(inputView.inputTrialCount());
        this.outputView = outputView;
        this.movement = movement;
    }

    public void run() {
        outputView.printResultMessage();
        while (trialCount.isHigherThanZero()) {
            cars.move(movement);
            outputView.printRoundStatus(cars.getCarInfos());
            trialCount.decrease();
        }
        outputView.printWinners(cars.getFarthestCar());
    }
}
