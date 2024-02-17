package controller;


import model.Race;
import utils.validator.TryCountValidator;
import view.InputView;

public class InputController {

    public Race makeRace() {
        try {
            String carNames = InputView.inputCarName();

            return new Race(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return makeRace();
        }
    }

    public int makeTryCount() {
        try {
            String invalidTryCount = InputView.inputTryCount();
            TryCountValidator.validateTryCountFormat(invalidTryCount);

            return Integer.parseInt(invalidTryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return makeTryCount();
        }
    }
}
