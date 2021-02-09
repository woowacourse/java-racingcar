package racingcar.domain;

public class Round {
    private final int round;

    public Round(int round) {
        this.round = round;
    }

    public boolean isBiggerThan(Round that){
        return this.round > that.round;
    }

    public int getRound(){
        return round;
    }
}
