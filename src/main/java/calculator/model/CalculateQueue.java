package calculator.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CalculateQueue {
    private Queue<String> queue;

    public CalculateQueue(String[] values) {
        queue = new LinkedList<>(Arrays.asList(values));
    }

    public double calculate() {
        double result = Double.parseDouble(queue.poll());
        while (!queue.isEmpty()) {
            String operator = queue.poll();
            double operand = Double.parseDouble(queue.poll());
            result = Operator.findOperator(operator).calculate(result, operand);
        }
        return result;
    }
}
