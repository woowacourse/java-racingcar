package view;

import domain.Cars;
import domain.Winner;

public class OutputView {
    public void printCarsDistance(Cars cars) {
        for (int i = 0; i < cars.getCarsSize(); i++) {
            String carName = cars.getCar(i).getCarName();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cars.getCar(i).getDistance(); j++) {
                sb.append('-');
            }
            System.out.println(carName + " : " + sb);
        }
        System.out.println();
    }

    public String carDistance(Cars cars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.getCar(i).getDistance(); i++) {
            sb.append('-');
        }
        return sb.toString();
    }

    public void printWinner(Winner winner) {
        String result = String.join(", ",winner.getWinners());
        System.out.println(result + "가 최종 우승했습니다");

    }
}
