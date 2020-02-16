package racing.model;

public class TrialTime {

    private int trialTime;

    public TrialTime(int trialTime) {
        checkTrialTimeNegativeOrZero(trialTime);
        this.trialTime = trialTime;
    }

    private void checkTrialTimeNegativeOrZero(int trialTime) {
        if (trialTime <= 0) {
            throw new IllegalArgumentException("시도횟수는 음수가 입력될 수 없습니다.");
        }
    }

    public void raceByTrialTime(CarLineUp lineUp) {
        for (int index = 0; index < trialTime; index++){
            lineUp.raceOneTime();
        }
    }
}
