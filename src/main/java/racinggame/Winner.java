package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<String> winners = new ArrayList<>();

    public boolean checkWinner(List<Car> cars, int maxInstance) {
        boolean winnerExist = false;

        for (Car car : cars) {
            boolean isMaxInstance = car.isMaxInstance(maxInstance);
            addWinner(isMaxInstance, car);
            winnerExist |= isMaxInstance;
        }

        return winnerExist;
    }

    private void addWinner(boolean isMaxInstance, Car car) {
        if (isMaxInstance) {
            winners.add(car.getName());
        }
    }

    public List<String> getWinners() {
        return winners;
    }
}
