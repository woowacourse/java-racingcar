package racingcar.domain;

public class AdvanceJudgement {
    private Range advanceNumberRange;
    private NumberGenerator numberGenerator;

    public AdvanceJudgement(Range advanceNumberRange, NumberGenerator numberGenerator) {
        this.advanceNumberRange = advanceNumberRange;
        this.numberGenerator = numberGenerator;
    }

    public Boolean isAdvancePossible() {
        int number = numberGenerator.getNumber();
        return advanceNumberRange.isInRange(number);
    }
}
