package racingcar.domain;

public class AdvanceJudgement {
    private final Range advanceNumberRange;
    private final NumberGenerator numberGenerator;

    public AdvanceJudgement(Range advanceNumberRange, NumberGenerator numberGenerator) {
        this.advanceNumberRange = advanceNumberRange;
        this.numberGenerator = numberGenerator;
    }

    public Boolean isAdvancePossible() {
        int number = numberGenerator.getNumber();
        return advanceNumberRange.isInRange(number);
    }
}
