package vo;

import java.util.Objects;

public class Trial {
    public static final String NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE = "양수의 숫자만 입력할 수 있습니다.";
    private final Long trial;

    private Trial(Long trial) {
        this.trial = trial;
    }

    public static Trial of(Long number) {
        validateNumber(number);
        return new Trial(number);
    }

    private static void validateNumber(Long number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public Long getValue() {
        return trial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial1 = (Trial) o;
        return trial.equals(trial1.trial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trial);
    }

    @Override
    public String toString() {
        return "Trial{" +
                "trial=" + trial +
                '}';
    }
}
