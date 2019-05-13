package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class StringCalculator {
    private Queue<Integer> numbers = new LinkedList<>();
    private Queue<String> operators = new LinkedList<>();

    public StringCalculator(String value) {
        String[] expression = value.split(" ");
        divideExpression(numbers, operators, expression);
    }

    private void divideExpression(Queue<Integer> numbers, Queue<String> operators, String[] expression) {
        for(int i = 0; i < expression.length; i = i + 2){
            numbers.add(Integer.parseInt(expression[i]));
        }
        for(int i = 1; i < expression.length; i = i + 2){
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
