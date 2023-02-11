package domain;

import static validation.CountValidator.COUNT_VALIDATOR;

public class Race {

    private final int TOTAL_COUNT;
    private int currentCount = 0;
    private Participants participants;

    public Race(final int totalCount, final Participants participants) {
        COUNT_VALIDATOR.validate(totalCount);
        this.TOTAL_COUNT = totalCount;
        this.participants = participants;
    }

    public void playRound() {
        participants.drive();
        addCount();
    }

    private void addCount() {
        currentCount += 1;
    }

    public boolean isFinished() {
        return TOTAL_COUNT == currentCount;
    }
}
