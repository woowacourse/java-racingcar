package calculator.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CalculateQueue {
    private Queue<String> queue;
    private double result = 0;

    public CalculateQueue(String[] values) {
        queue = new LinkedList<>(Arrays.asList(values));
    }

    public double calculate() {
        result = Double.parseDouble(queue.poll());
        while (!queue.isEmpty()) {
            String operator = queue.poll();
            double operand = Double.parseDouble(queue.poll());
            result = this.calculateByOperator(operator, operand);
        }
        return result;
    }

    public double calculateByOperator(String operator, double operand) {
        if (operator.equals("+")) {
            return Calculator.plus(result, operand);
        }
        if (operator.equals("-")) {
            return Calculator.minus(result, operand);
        }
        if (operator.equals("*")) {
            return Calculator.multiply(result, operand);
        }
        return Calculator.divide(result, operand);
    }
}
