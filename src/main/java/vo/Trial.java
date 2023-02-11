package vo;

import java.util.Objects;

public class Trial {
    private final Long trial;

    private Trial(Long trial) {
        this.trial = trial;
    }

    public static Trial of(Long number) {
        return new Trial(number);
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
