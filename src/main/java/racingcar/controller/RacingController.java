package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.MoveOrStop;
import racingcar.view.InputView.InputView;
import racingcar.view.OutputView.ConsoleOutputView;
import racingcar.view.OutputView.OutputView;

public class RacingController {
    private final OutputView outputView;
    private final MoveOrStop moveOrStop;

    private final Cars cars;
    private int trialCount;

    public RacingController(InputView inputView, ConsoleOutputView outputView, MoveOrStop moveOrStop) {
        cars = new Cars(inputView.inputCarNames());
        trialCount = inputView.inputTrialCount();
        this.outputView = outputView;
        this.moveOrStop = moveOrStop;
    }

    public void run() {
        outputView.printResultMessage();
        while(trialCount > 0) {
            cars.move(moveOrStop);
            outputView.printRoundStatus(cars.getCarInfos());
            trialCount--;
        }
        outputView.printWinners(cars.getFarthestCar());
    }
}
