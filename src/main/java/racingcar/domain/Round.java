package racingcar.domain;

import racingcar.validator.RoundValidator;

public class Round {

    private int count;

    private Round(int count){
        RoundValidator.isPositive(count);
        this.count = count;
    }

    public static Round create(int inputNumber){
        return new Round(inputNumber);
    }

    public void next() {
        count--;
    }

    public boolean isEnd(){
        return count < 0;
    }
}
