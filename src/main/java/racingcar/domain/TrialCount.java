package racingcar.domain;

public class TrialCount {
    private int trialCount;

    public TrialCount(int inputTrialCount) {
        this.trialCount = inputTrialCount;
    }

    public int getTrialCount() {
        return trialCount;
    }

    public void minus(){
        trialCount--;
    }
}
