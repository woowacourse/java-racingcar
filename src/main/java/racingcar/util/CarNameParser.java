package racingcar.util;

import racingcar.validator.CarNameValidator;

public class CarNameParser {
    private static final String CAR_NAME_DELIMINATOR = ",";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    public static String[] parseCarNameInputs(String inputs) {
        CarNameValidator carNameValidator = new CarNameValidator();
        inputs = removeBlank(inputs);
        String[] carNames = inputs.split(CAR_NAME_DELIMINATOR);
        for (String carName : carNames) {
            carNameValidator.validateCarName(carName);
        }
        return carNames;
    }

    private static String removeBlank(String text) {
        return text.replaceAll(BLANK, EMPTY);
    }
}
