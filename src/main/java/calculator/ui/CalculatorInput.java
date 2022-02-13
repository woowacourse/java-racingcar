package calculator.ui;

import calculator.CalculatorMain;
import calculator.domain.UserInputForm;
import calculator.utils.validator.UserInputValidator;

public class CalculatorInput {
    private static final String INPUT_MESSAGE = "입력: ";
    private static final int CUSTOM_DELIMITER_PREFIX_LENGTH = 2;
    private static final String CUSTOM_DELIMITER_END_FLAG = "\\";
    private static final String FORMULA_START_FLAG = "n";

    public UserInputForm userInput() {
        String inputText = printMessageAndInput();
        if (UserInputValidator.isNullOrWhiteSpace(inputText)) {
            return new UserInputForm("0");
        }
        if (UserInputValidator.isCustomDelimiter(inputText)) {
            return new UserInputForm(extractCustomDelimiter(inputText), extractFormula(inputText));
        }
        return new UserInputForm(inputText);
    }

    private String extractCustomDelimiter(String firstInput) {
        return firstInput.substring(CUSTOM_DELIMITER_PREFIX_LENGTH, firstInput.indexOf(CUSTOM_DELIMITER_END_FLAG));
    }

    private String extractFormula(String inputText) {
        return inputText.substring(inputText.indexOf(FORMULA_START_FLAG) + 1);
    }

    private String printMessageAndInput() {
        System.out.print(INPUT_MESSAGE);
        return CalculatorMain.sc.nextLine();
    }
}
