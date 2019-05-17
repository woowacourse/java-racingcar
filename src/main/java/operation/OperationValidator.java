package operation;

public class OperationValidator {

    static double isNumber(String index) {
        try {

            return Double.parseDouble(index);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("적절한 값이 아닙니다.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("다항식의 순서가 부적절 합니다.");
        }
    }

    static String checkDivideByZero(String operator, double number) {
        if (operator.equals("/") && number == 0) {
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
        }
        return operator;
    }

}
