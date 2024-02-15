package controller;

import model.Race;
import view.InputView;

public class InputController {

    public Race makeRace() {
        String carNames = InputView.inputCarName();

        return new Race(carNames);
    }

    public int makeTryNumber() {
        String s = InputView.inputTryCount();

        return Integer.parseInt(s);
    }
}
