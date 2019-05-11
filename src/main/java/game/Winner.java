package game;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<String> winners = new ArrayList<>();

    public boolean checkWinner(List<Car> cars, int maxInstance) {
        boolean result = false;

        for (Car car : cars) {
            result |= isMaxInstanceAndAddWinner(maxInstance, car);
        }

        return result;
    }

    private boolean isMaxInstanceAndAddWinner(int maxInstance, Car car) {
        boolean isMaxInstance = car.isMaxInstance(maxInstance);
        addWinner(isMaxInstance, car);
        return isMaxInstance;
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
