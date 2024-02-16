package controller;

import static utils.TryCountValidator.validateTryCountFormat;

import java.util.List;
import model.Race;
import utils.InputStringParser;
import view.InputView;

public class InputController {
    private final InputView inputView;

    public InputController() {
        this.inputView = new InputView();
    }

    public Race getRace() {
        try {
            List<String> carNames = InputStringParser.parseInputToList(inputView.inputCarName());
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
