package racingcar.domain.vo;

import java.util.Objects;

public class Trial {
    private static final int MINIMUM = 1;

    private int count;

    public Trial(int count) {
        validateRange(count);
        this.count = count;
    }

    public void minus() {
        if (count >= MINIMUM) {
            this.count--;
        }
    }

    public int getTrial() {
        return this.count;
    }

    public boolean isExists() {
        return this.count >= MINIMUM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Trial)) {
            return false;
        }
        Trial trial = (Trial)o;
        return count == trial.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    private void validateRange(int count) {
        if (count < MINIMUM) {
            throw new IllegalArgumentException("시도 횟수는 1 이상을 입력해주세요.");
        }
    }
}
