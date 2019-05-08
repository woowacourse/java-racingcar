package calculator.controller;

import calculator.model.CalculateQueue;
import calculator.view.View;

public class Controller {
    public void run(){
        String[] input = View.input();
        CalculateQueue calculateQueue = new CalculateQueue(input);
        calculateQueue.calculate();
    }
}
