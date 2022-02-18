package racingcar.domain.vo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RoundResult {

    private Map<String, Integer> roundResult = new LinkedHashMap<>();

    public void add(Car car) {
        String name = car.getName().get();
        int position = car.getPosition().get();
        roundResult.put(name, position);
    }

    public Set<String> getNames() {
        return roundResult.keySet();
    }

    public Integer getPosition(String name) {
        return roundResult.get(name);
    }
}
