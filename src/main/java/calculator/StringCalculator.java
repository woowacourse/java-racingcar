package calculator;

import calculator.util.InputStrValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String inputStr) {
        if (InputStrValidator.isEmptyOrNull(inputStr)) {
            return 0;
        }
        if (InputStrValidator.isOnlyOneNumber(inputStr)) {
            return Integer.parseInt(inputStr);
        }
        return -1;
    }
}
