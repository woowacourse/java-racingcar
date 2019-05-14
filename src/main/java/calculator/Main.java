package calculator;

import calculator.model.CalculateQueue;
import calculator.view.View;

public class Main {
    public static void main(String[] args) {
        String[] input = View.inputFormula();
        CalculateQueue calculateQueue = new CalculateQueue(input);
        View.outputLine(String.valueOf(calculateQueue.calculate()));
    }
}
