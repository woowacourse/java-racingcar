package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class StringCalculator {
    private Queue<Integer> numbers = new LinkedList<>();
    private Queue<String> operators = new LinkedList<>();
    private final static int EVEN_ODD_DIVISION_NUMBER = 2;
    private final static int EVEN_START_NUMBER = 0;
    private final static int ODD_START_NUMBER = 1;

    public StringCalculator(String value) {
        String[] expression = value.split(" ");
        divideExpression(numbers, operators, expression);
    }

    private void divideExpression(Queue<Integer> numbers, Queue<String> operators, String[] expression) {
        for(int i = EVEN_START_NUMBER; i < expression.length; i = i + EVEN_ODD_DIVISION_NUMBER){
            numbers.add(Integer.parseInt(expression[i]));
        }
        for(int i = ODD_START_NUMBER; i < expression.length; i = i + EVEN_ODD_DIVISION_NUMBER){
            operators.add(expression[i]);
        }
    }

    public int calculate() {
        int result = Operator.of(operators.poll()).calculate(numbers.poll(), numbers.poll());
        while (!operators.isEmpty()) {
            result = Operator.of(operators.poll()).calculate(result, numbers.poll());
        }
        return result;
    }
}
