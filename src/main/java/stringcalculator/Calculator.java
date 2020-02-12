package stringcalculator;

import stringcalculator.parser.StringParserGroup;

import java.util.List;

public class Calculator {
    public static int calculate(String input) {
        List<String> maybeNumbers = StringParserGroup.findByInput(input)
                .parse();
        PositiveNumbers positiveNumbers = new PositiveNumbers(maybeNumbers);
        return positiveNumbers.getSum();
    }
}
