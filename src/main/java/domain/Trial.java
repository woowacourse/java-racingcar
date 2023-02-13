package domain;

public class Trial {
    private int trial;

    public Trial(int trial) {
        this.trial = trial;
    }

    public boolean isRemainTrial() {
        return this.trial > 0;
    }

    public void doTryOne() {
        this.trial--;
    }
}
