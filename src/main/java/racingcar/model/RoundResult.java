package racingcar.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class RoundResult {

    private final Map<String, Integer> roundResult;

    public RoundResult() {
        this.roundResult = new LinkedHashMap<>();
    }

    public void addResult(Car car) {
        roundResult.put(car.getName(), car.getCarPosition());
    }

    public Set<String> getParticipantsNames() {
        return roundResult.keySet();
    }

    public int findLocationBy(String participantsName) {
        return roundResult.get(participantsName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoundResult that = (RoundResult) o;
        return roundResult.equals(that.roundResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundResult);
    }
}
