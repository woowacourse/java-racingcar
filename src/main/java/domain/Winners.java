package domain;

import java.util.ArrayList;

public class Winners {
    private int maxPosition;
    private ArrayList<Car> winnerList = new ArrayList<>();

    public Winners() {
        this.maxPosition = 0;
    }

    public void determineWinners(ArrayList<Car> cars) {
        int maxPosition = getMaxPosistion(cars);
        searchWinners(maxPosition, cars);
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
                winnerList.add(car);
            }
        }
    }

    public void printWinners() {
        String winnerNames = "";
        String message;

        for (Car winner : winnerList) {
            winnerNames = winner.appendWinnerName(winnerNames);
        }

        message = winnerNames.substring(0, winnerNames.length() - 2);
        System.out.format("%s 이(가) 최종 우승했습니다.\n", message);
    }
}
