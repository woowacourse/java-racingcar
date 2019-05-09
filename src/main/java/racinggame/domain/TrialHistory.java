package racinggame.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrialHistory {
    private HashMap<String, Integer> trialHistory = new HashMap<>();

    public TrialHistory(List<Car> cars) {
        for (Car car : cars) {
            trialHistory.putAll(car.makeCarHisory());
        }
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;

        for (String carName : trialHistory.keySet()) {
            maxPosition = Math.max(trialHistory.get(carName), maxPosition);
        }
        for (String carName : trialHistory.keySet()) {
            if (trialHistory.get(carName) == maxPosition) {
                winners.add(carName);
            }
        }
        return winners;
    }
}
