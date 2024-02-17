package controller;


import model.Race;
import utils.CarNameConvertor;
import utils.validator.CarValidator;
import utils.validator.TryCountValidator;
import view.InputView;

public class InputController {

    public Race makeRace() {
        try {
            String carNames = InputView.inputCarName();
            new CarValidator().validate(carNames);

            return new Race(CarNameConvertor.splitCarNames(carNames));
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
