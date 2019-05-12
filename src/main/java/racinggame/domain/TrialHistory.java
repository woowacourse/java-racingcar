package racinggame.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TrialHistory {
    private Map<String, Integer> trialHistory = new LinkedHashMap<>();

    public TrialHistory(final List<Car> cars) {
        for (Car car : cars) {
            trialHistory.putAll(car.makeCarHistory());
        }
    }

    public List<String> findWinners() {
        final int maxCarPosition = getMaxCarPosition();

        return trialHistory.keySet().stream()
                .filter(carName -> trialHistory.get(carName) == maxCarPosition)
                .collect(Collectors.toList());
    }

    private int getMaxCarPosition() {
        int maxCarPosition = 0;

        for (String carName : trialHistory.keySet()) {
            maxCarPosition = Math.max(trialHistory.get(carName), maxCarPosition);
        }
        return maxCarPosition;
    }

    public Map<String, Integer> getTrialHistory() {
        return trialHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrialHistory that = (TrialHistory) o;
        return Objects.equals(trialHistory, that.trialHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trialHistory);
    }
}
