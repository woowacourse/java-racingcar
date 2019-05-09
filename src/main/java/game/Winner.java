package game;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    //private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();
   // private int maxInstance;

    /*public Winner(List<Car> cars, int maxInstance) {
        this.cars = cars;
        this. maxInstance = maxInstance;
    }*/

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
