package domain;

import java.util.ArrayList;

public class Winners {
    private int maxPosition;
    private ArrayList<Car> winners;

    public Winners() {
        maxPosition = 0;
    }

    public void determineWinners(ArrayList<Car> cars) {
        //maxPosition
        //position 비교
    }

    private int getMaxPosistion(ArrayList<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.updateMaxPosition(maxPosition);
        }

        return maxPosition;
    }

    private void searchWinners(int maxPosition, ArrayList<Car> cars) {

        for (Car car : cars) {
            if (car.compareToPosition(maxPosition)) {
                winners.add(car);
            }
        }
    }

    public void printWinners() {
        //
    }
}
