package calculator.exception;

public class NumberIsNegativeException extends CalculatorException {

    public NumberIsNegativeException() {
        super("음수를 입력하셨습니다.");
    }

}
