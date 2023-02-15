package racingcar.domain;

public class Lap {
    private int lap;

    public Lap(int lap) {
        this.lap = lap;
    }

    public void reduce() {
        lap--;
    }

    public boolean isFinish() {
        return lap == 0;
    }
}
