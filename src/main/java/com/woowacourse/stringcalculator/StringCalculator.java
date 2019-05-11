package com.woowacourse.stringcalculator;

import java.util.Queue;

public class StringCalculator {
    private Queue<IntOperator> operatorQueue;
    private Queue<Integer> numberQueue;

    public StringCalculator(Queue<IntOperator> operatorQueue, Queue<Integer> numberQueue) {
        if (operatorQueue.size() != numberQueue.size() - 1) {
            throw new IllegalArgumentException("연산자와 피연산자 갯수가 맞지 않습니다");
        }

        this.operatorQueue = operatorQueue;
        this.numberQueue = numberQueue;
    }

    public int calculate() {
        int result = numberQueue.poll();
        int length = numberQueue.size();
        for (int i = 0; i < length; i++) {
            int curNum = numberQueue.poll();
            IntOperator operator = operatorQueue.poll();
            result = operator.execute(result, curNum);
        }

        return result;
    }
}
