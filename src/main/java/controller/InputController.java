package controller;

import java.util.List;
import model.Race;
import utils.InputStringParser;
import utils.TryCountValidator;
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
            String tryCount = inputView.inputTryCount();
            TryCountValidator.validateTryCountFormat(tryCount);
            return Integer.parseInt(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryCount();
        }
    }
}
