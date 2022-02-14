package calculator.exception;

public class NumberIsNotNumericException extends CalculatorException {

    public NumberIsNotNumericException() {
        super("숫자 이외의 값을 입력하셨습니다.");
    }

}
