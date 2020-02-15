package calculator;

import racingCar.domain.errors.InvalidInputException;

import static java.lang.Character.isDigit;

public class NumberExpression {
    private String numberExpression = "0";

    public NumberExpression(String numberExpression) {
        if (hasCustomSeperator(numberExpression)) {
            this.numberExpression = numberExpression;
            return;
        }
        if (containsLetter(numberExpression)) {
            throw new RuntimeException("문자를 포함합니다");
        }
        if (isEmpty(numberExpression)) {
            this.numberExpression = "0";
            return;
        }

        this.numberExpression = numberExpression;
    }

    boolean hasCustomSeperator(String numberExpression) {
        return numberExpression.startsWith("//") && numberExpression.substring(3, 4).equals("\n");
    }

    boolean hasCustomSeperator() {
        return numberExpression.startsWith("//") && numberExpression.substring(3, 4).equals("\n");
    }

    String getSeperator() {
        return numberExpression.substring(2,3);
    }

    String getPureNumberExpression() {
        return numberExpression.substring(4);
    }

    private boolean containsLetter(String numberExpression) {
        for (int i = 0; i < numberExpression.length(); i++) {
            if (!isDigit(numberExpression.charAt(i)) && !isSeperator(numberExpression.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isSeperator(Character charAt) {
        return charAt.equals(':') || charAt.equals(',');
    }

    private boolean isEmpty(String numberExpression) {
        return numberExpression.isEmpty();
    }

    String[] splitWithDefaultSeperators() {
        return numberExpression.split(",|:");
    }
}

