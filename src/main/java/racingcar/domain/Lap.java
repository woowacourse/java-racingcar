package racingcar.domain;

public class Lap {
    private final int lap;

    public Lap(String inputLap) {
        this.lap = Integer.parseInt(inputLap);
    }

    public int getLap() {
        return lap;
    }
}
