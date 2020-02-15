package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private int result = 0;
    public int add(String numberExpression) {
        if (hasCustomSeperator(numberExpression)) {
            String seperator = numberExpression.substring(2,3);
            addNumbersInExpressionBySeparator(numberExpression.substring(4), seperator);
            return result;
        }

        if (containsLetter(numberExpression)) {
            throw new RuntimeException("문자를 포함합니다");
        }

        if (numberExpression.isEmpty()) {
            return result;
        }

        addNumbersInExpressionBySeparators(numberExpression);

        return result;
    }

    private void addNumbersInExpressionBySeparators(String numberExpression) {
        String[] numbers = numberExpression.split(",|:");
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
    }

    private boolean hasCustomSeperator(String numberExpression) {
        return numberExpression.startsWith("//") && numberExpression.substring(3, 4).equals("\n");
    }

    private boolean containsLetter(String numberExpression) {
        for (int i = 0; i < numberExpression.length(); i++) {
            if (!isDigit(numberExpression.charAt(i)) && !isSeperator(numberExpression.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isSeperator(Character charAt) {
        return charAt.equals(':') || charAt.equals(',');
    }

    private boolean isDigit(Character charAt) {
        return Character.isDigit(charAt);
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
        return splittedWord.length() == 1;
    }
}
