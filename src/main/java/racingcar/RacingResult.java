package racingcar;

import java.util.ArrayList;

public class RacingResult {
    private ArrayList<Integer>[] carPositionHistory;

    public RacingResult(String[] carNames) {
        this.carPositionHistory = new ArrayList[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            carPositionHistory[i] = new ArrayList<>();
        }
    }

    public void recordCarPositionHistory(int carIndex, Car car) {
        carPositionHistory[carIndex].add(car.getPosition());
    }

    public ArrayList<Integer>[] getCarPositionHistory() {
        return carPositionHistory;
    }
}
