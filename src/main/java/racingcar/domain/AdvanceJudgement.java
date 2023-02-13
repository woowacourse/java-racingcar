package racingcar.domain;

import racingcar.domain.NumberGenerator.NumberGenerator;

public class AdvanceJudgement {
    private static final int ADVANCE_MIN_NUMBER = 4;
    public static final int ADVANCE_MAX_NUMBER = 9;
    private final Range advanceNumberRange = new Range(ADVANCE_MIN_NUMBER, ADVANCE_MAX_NUMBER);
    private final NumberGenerator numberGenerator;

    public AdvanceJudgement(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Boolean isAdvancePossible() {
        int number = numberGenerator.getNumber();
        return advanceNumberRange.isInRange(number);
    }
}
