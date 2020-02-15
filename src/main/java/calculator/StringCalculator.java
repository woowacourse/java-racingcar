package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private int result = 0;
    public int add(NumberExpression numberExpression) {
        if (numberExpression.hasCustomSeperator()) {
            String seperator = numberExpression.getSeperator();
            addNumbersInExpressionBySeparator(numberExpression.getPureNumberExpression(), seperator);
            return result;
        }

        addNumbersInExpressionBySeparators(numberExpression);

        return result;
    }

    private void addNumbersInExpressionBySeparators(NumberExpression numberExpression) {
        String[] numbers = numberExpression.splitWithDefaultSeperators();
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
    }

    private List<String> addNumbersInExpressionBySeparator(String numberExpression, String seperator) {
        String[] splittedNumberExpression = numberExpression.split(seperator);
        return addSplittedNumberExpression(splittedNumberExpression);
    }

    private List<String> addSplittedNumberExpression(String[] splittedNumberExpression) {
        List<String> notSplittedExpression = new ArrayList<>();

        for (String splittedWordWithComma : splittedNumberExpression) {
            boolean isAdded = addNumber(splittedWordWithComma);
            if (isAdded) {
                continue;
            }
            notSplittedExpression.add(splittedWordWithComma);
        }

        return notSplittedExpression;

    }

    private boolean addNumber(String splittedWord) {
        if (isInteger(splittedWord)) {
            result += Integer.parseInt(splittedWord);
            return true;
        }
        return false;
    }

    private boolean isInteger(String splittedWord) {
        try {
            Integer.parseInt(splittedWord);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
