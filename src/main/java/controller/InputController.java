package controller;

import model.Race;
import utils.TryCountValidator;
import view.InputView;

public class InputController {

    public Race makeRace() {
        try {
            String carNames = InputView.inputCarName();
            Race race = new Race(carNames);

            return race;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return makeRace();
        }
    }

    public int makeTryNumber() {
        try {
            String invalidTryCount = InputView.inputTryCount();
            TryCountValidator.validateTryCountFormat(invalidTryCount);

            return Integer.parseInt(invalidTryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return makeTryNumber();
        }
    }
}
