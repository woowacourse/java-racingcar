package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.model.car.Names;
import racingcar.model.trycount.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private TryCount tryCount;
    private Cars cars = Cars.create();

    public RaceController() {
    }

    public void setUpCars() {
        try {
            String input = InputView.inputNamesUi();
            Names names = Names.from(input);
            cars = Cars.from(names);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorUi(exception);
            setUpCars();
        }
    }

    public void setUpTryCount() {
        try {
            String input = InputView.inputTryCountUi();
            tryCount = TryCount.from(input);
            System.out.println(tryCount.toInt());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorUi(exception);
            setUpTryCount();
        }
    }

    public void raceStart() {
        OutputView.printRaceResultUi();
        for (int i = 0; i < tryCount.toInt(); i++) {
            cars.moveAll();
            OutputView.printCarsUi(cars);
        }
    }

    public void raceEnd() {
        OutputView.printRaceResultUi(cars.getWinnersNames());
    }

}
