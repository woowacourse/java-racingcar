package racingcargame.controller;

import racingcargame.domain.Cars;
import racingcargame.domain.Names;
import racingcargame.view.input.InputView;
import racingcargame.view.output.OutputView;

public class CarRace {
    private Cars cars;
    private TryNumber tryNumber;

    public CarRace() {
        this.cars = new Cars(Names.valueOf(InputView.askCarNames()));
        this.tryNumber = new TryNumber(Integer.parseInt(InputView.askTotalRounds()));
    }

    public void start() {
        OutputView.printResultTitle();
        while (tryNumber.isNotZero()) {
            cars.moveOneRound();
            OutputView.printRaceResults(cars.getCars());
            tryNumber.reduce();
        }
        OutputView.printWinners(cars.findWinnerNames());
    }
}
