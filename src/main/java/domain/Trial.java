package domain;

import exception.NegativeTrialException;

import java.util.Objects;

public class Trial {
    public static final Trial EMPTY = from(0);

    private final int trial;

    private Trial(int trial) {
        checkTrial(trial);
        this.trial = trial;
    }

    private void checkTrial(int trial) {
        if (trial < 0) {
            throw new NegativeTrialException("Trial 은 음이 아닌 정수여야 합니다.");
        }
    }

    public static Trial from(int trial) {
        return new Trial(trial);
    }

    public Trial adjust() {
        return new Trial(trial - 1);
    }

    public boolean isEmpty() {
        return this.equals(EMPTY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial1 = (Trial) o;
        return trial == trial1.trial;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trial);
    }
}
