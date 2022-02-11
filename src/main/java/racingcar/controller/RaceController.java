package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.model.input.Names;
import racingcar.view.InputView;

public class RaceController {
    private Cars cars = Cars.create();

    public RaceController() {
    }

    public void setUpCars() {
        try {
            String input = InputView.inputNamesUi();
            Names names = Names.from(input);
            cars = Cars.from(names);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setUpCars();
        }
    }
}
