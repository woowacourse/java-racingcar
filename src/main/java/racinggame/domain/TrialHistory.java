package racinggame.domain;

import racinggame.util.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrialHistory {
    private HashMap<String, Integer> trialHistory = new HashMap<>();

    public TrialHistory(List<Car> cars) {
        for (Car car : cars) {
            trialHistory.putAll(car.makeCarHistory());
        }
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int maxCarPosition = getMaxCarPosition();

        for (String carName : trialHistory.keySet()) {
            if (trialHistory.get(carName) == maxCarPosition) {
                winners.add(carName);
            }
        }
        return winners;
    }

    private int getMaxCarPosition() {
        int maxCarPosition = 0;

        for (String carName : trialHistory.keySet()) {
            maxCarPosition = Math.max(trialHistory.get(carName), maxCarPosition);
        }
        return maxCarPosition;
    }

    public void showTrialResult() {
        for (String carName : trialHistory.keySet()) {
            OutputView.showRaceResult(carName, trialHistory.get(carName));
        }
    }
}
