package calculator.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CalculateQueue {
    private Queue<String> Queue;

    public CalculateQueue(String[] values){
        Queue= new LinkedList<>(Arrays.asList(values));
    }

}
