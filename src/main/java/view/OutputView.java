package view;

import domain.Cars;
import domain.Winner;

public class OutputView {
    public void printCarsDistance(Cars cars) {
        for (int i = 0; i < cars.getCarsSize(); i++) {
            String carName = cars.getCar(i).getCarName();
            System.out.println(carName + " : " + drawDistance(cars, i));
        }
        System.out.println();
    }

    private static String drawDistance(Cars cars, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cars.getCar(i).getDistance(); j++) {
            sb.append('-');
        }
        return sb.toString();
    }

    public void printWinner(Winner winner) {
        String result = String.join(", ",winner.getWinners());
        System.out.println(result + "가 최종 우승했습니다");
    }
}
