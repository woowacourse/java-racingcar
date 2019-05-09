package domain;

import java.util.ArrayList;

public class WinnerCars {

    public ArrayList<Car> determineWinners(ArrayList<Car> carList) {
        int maxPosition = getMaxPosition(carList);

        return searchWinners(maxPosition, carList);
    }

    private int getMaxPosition(ArrayList<Car> carList) {
        int maxPosition = 0;

        for (Car car : carList) {
            maxPosition = car.getLargePosition(maxPosition);
        }

        return maxPosition;
    }

    private ArrayList<Car> searchWinners(int maxPosition, ArrayList<Car> carList) {
        ArrayList<Car> winnerList = new ArrayList<>();

        for (Car car : carList) {
            if (car.compareToPosition(maxPosition)) {
                winnerList.add(car);
            }
        }

        return winnerList;
    }
}
