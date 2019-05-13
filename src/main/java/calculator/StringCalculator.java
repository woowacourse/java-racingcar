package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class StringCalculator {
    private final static String PLUS = "+";
    private final static String MINUS = "-";
    private final static String MULTIPLE = "*";
    private final static String DIVIDE = "/";

    private Queue<Integer> numbers = new LinkedList<>();
    private Queue<String> operators = new LinkedList<>();

    public StringCalculator(String value) {
        String[] expression = value.split(" ");
        divideExpression(numbers, operators, expression);
    }

    private void divideExpression(Queue<Integer> numbers, Queue<String> operators, String[] expression) {
        for (int i = 0; i < expression.length; i++) {
            if (i % 2 == 0) { // even
                numbers.add(Integer.parseInt(expression[i]));
            }
            if (i % 2 == 1) { // odd
                operators.add(expression[i]);
            }
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
