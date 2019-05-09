package game;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<String> winners = new ArrayList<>();

    public boolean checkWinner(List<Car> cars, int maxInstance) {
        boolean result = false;

        for (Car car : cars) {
            boolean isMaxInstance = car.isMaxInstance(maxInstance);
            addWinner(isMaxInstance, car);
            result |= isMaxInstance;
        }

        return result;
    }

    public void addWinner(boolean isMaxInstance, Car car) {
        if (isMaxInstance) {
            winners.add(car.getCarName());
        }
    }

    public List<String> getWinners() {
        return winners;
    }
}
