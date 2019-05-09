package domain;

import utils.OutputUtil;

import java.util.ArrayList;

class WinnerCars {
    private ArrayList<Car> winnerList = new ArrayList<>();

    void determineWinners(ArrayList<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        searchWinners(maxPosition, cars);
    }

    private int getMaxPosition(ArrayList<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
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

    void printWinners() {
        OutputUtil.printWinners(winnerList);
    }

//    void printWinners() {
//        String winnerNames = "";
//        String message;
//
//        for (Car winner : winnerList) {
//            winnerNames = winner.appendCarName(winnerNames);
//        }
//
//        message = winnerNames.substring(0, winnerNames.length() - 2);
//        System.out.format("%s 이(가) 최종 우승했습니다.\n", message);
//    }
}
