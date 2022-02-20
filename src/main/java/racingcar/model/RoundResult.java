package racingcar.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RoundResult {

    private final Map<String, Integer> roundResult = new LinkedHashMap<>();

    public void addResult(Car car) {
        roundResult.put(car.getName(), car.getCarPosition());
    }

    public Set<String> getParticipantsNames() {
        return roundResult.keySet();
    }

    public int findLocationBy(String participantsName) {
        return roundResult.get(participantsName);
    }
}
