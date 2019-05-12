package calculator;

import exceptionsCalculator.CalculatorException;

enum Calculate {
    RESULT();

    public int getCalculateResult(int firstNumber, int secondNumber, String symbol) {
        if (symbol.equals("+")) return firstNumber + secondNumber;
        if (symbol.equals("-")) return firstNumber - secondNumber;
        if (symbol.equals("*")) return firstNumber * secondNumber;
        if (symbol.equals("/")) return CalculatorException.divisionException(firstNumber, secondNumber);
        return CalculatorException.applyCalculationException();
    }
}
