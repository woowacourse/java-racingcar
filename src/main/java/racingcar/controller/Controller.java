package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.Trial;

public class Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final RandomNumberGenerator randomNumberGenerator;

    private final Cars cars;
    private final Trial trial;

    public Controller() {
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.cars = new Cars(inputView.inputCarName());
        this.trial = initGameTime();
    }

    private Trial initGameTime() {
        String trial = inputView.inputGameTime();
        return new Trial(trial);
    }

    public void startRacing() {
        while (trial.ieLeft()) {
            cars.moveCars(randomNumberGenerator);
            trial.useOneTime();
            outputView.printPosition(cars.getCars());
        }
    }

    public void endRacing() {
        outputView.printPosition(cars.getCars());
        outputView.printWinners(cars.getWinnerNames());
    }

}
