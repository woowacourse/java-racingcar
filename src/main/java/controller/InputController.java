package controller;

import static utils.TryCountValidator.validateTryCountFormat;

import model.Race;
import view.InputView;

public class InputController {
    private final InputView inputView;

    public InputController() {
        this.inputView = new InputView();
    }

    public Race getRace() {
        try {
            String carNames = inputView.inputCarName();
            return new Race(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRace();
        }
    }

    public int getTryCount() {
        try {
            String invalidTryCount = inputView.inputTryCount();
            validateTryCountFormat(invalidTryCount);
            return Integer.parseInt(invalidTryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryCount();
        }
    }
}
