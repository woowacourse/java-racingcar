package racinggame.domain;

import java.util.HashMap;
import java.util.List;

public class TrialHistory {
    private HashMap<String, Integer> trialHistory = new HashMap<>();

    public TrialHistory(List<Car> cars) {
        for (Car car : cars) {
            trialHistory.putAll(car.makeCarHisory());
        }
    }
}
