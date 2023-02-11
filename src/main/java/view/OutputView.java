package view;

import domain.Cars;
import domain.Winner;

public class OutputView {

    private final static String DELIMITER = " : ";
    private final static String JOIN_COMMA = ", ";
    private final static String FINAL_WINNER = "가 최종 우승했습니다";

    private static String drawDistance(Cars cars, int i) {
        String bar = "-";
        return bar.repeat(cars.getCar(i).getDistance());
    }

    public void printCarsDistance(Cars cars) {
        for (int i = 0; i < cars.getCarsSize(); i++) {
            String carName = cars.getCar(i).getCarName();
            System.out.println(carName + DELIMITER + drawDistance(cars, i));
        }
        System.out.println();
    }

    public void printWinner(Winner winner) {
        String result = String.join(JOIN_COMMA, winner.getWinners());
        System.out.println(result + FINAL_WINNER);
    }
}
