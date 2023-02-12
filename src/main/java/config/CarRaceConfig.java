package config;

import controller.CarRaceController;
import validation.InputValidationChain;
import validation.impl.EmptyValueValidationChain;
import validation.impl.InputValidateSuccessChain;
import validation.impl.NumberRangeValidationChain;
import validation.impl.PositiveNumberValidationChain;
import view.InputView;
import view.OutputView;

public class CarRaceConfig {

    public static CarRaceController config() {
        return new CarRaceController(new InputView(), new OutputView(),
            makeValidator());
    }

    private static InputValidationChain makeValidator() {
        final InputValidationChain emptyValueValidationChain = new EmptyValueValidationChain();
        final InputValidationChain numberRangeValidationChain = new NumberRangeValidationChain();
        final InputValidationChain positiveNumberValidationChain = new PositiveNumberValidationChain();
        final InputValidationChain inputValidationChain = new InputValidateSuccessChain();
        emptyValueValidationChain.setNext(numberRangeValidationChain);
        numberRangeValidationChain.setNext(positiveNumberValidationChain);
        positiveNumberValidationChain.setNext(inputValidationChain);
        return emptyValueValidationChain;
    }
}
