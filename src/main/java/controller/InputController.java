package controller;

import static utils.TryCountValidator.validateTryCountFormat;
import static view.InputView.inputCarName;
import static view.InputView.inputTryCount;

import model.Race;

public class InputController {

    public Race makeRace() {
        try {
            String carNames = inputCarName();
            Race race = new Race(carNames);

            return race;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return makeRace();
        }
    }

    public int makeTryCount() {
        try {
            String invalidTryCount = inputTryCount();
            validateTryCountFormat(invalidTryCount);

            return Integer.parseInt(invalidTryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return makeTryCount();
        }
    }
}
