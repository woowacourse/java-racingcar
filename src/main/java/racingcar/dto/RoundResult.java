package racingcar.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.domain.vo.Car;

public class RoundResult {

    private final Map<String, Integer> roundResult = new LinkedHashMap<>();

    public RoundResult(List<Car> cars) {
        for (Car car : cars) {
            String name = car.getName().get();
            int position = car.getPosition().get();
            roundResult.put(name, position);
        }
    }

    public Set<String> getNames() {
        return roundResult.keySet();
    }

    public Integer getPosition(String name) {
        return roundResult.get(name);
    }
}
