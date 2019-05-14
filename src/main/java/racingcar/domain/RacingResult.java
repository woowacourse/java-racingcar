package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class RacingResult {
    String result;

    public RacingResult() {
    }

    @Override
    public String toString() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingResult that = (RacingResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

}
