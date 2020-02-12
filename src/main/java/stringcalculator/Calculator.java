package stringcalculator;

import stringcalculator.parser.StringParserGroup;

import java.util.List;

public class Calculator {
    public static int calculate(String input) {
        InputStringDTO inputStringDTO = new InputStringDTO(input);
        List<String> maybeNumbers = StringParserGroup.findByInput(inputStringDTO.getInput())
                .parse();
        PositiveNumbers positiveNumbers = new PositiveNumbers(maybeNumbers);
        return positiveNumbers.getSum();
    }
}
