package racingcar.view;

import racingcar.Cars;
import racingcar.Winners;

public class OutputView {
    public static void printTheProcess(Cars cars, int totalTurns) {
        System.out.println("실행 결과");
        for (int currentTurn = 0; currentTurn < totalTurns; currentTurn++) {
            updateAndPrintMovement(cars);
            System.out.println();
        }
    }

    public static void updateAndPrintMovement(Cars cars) {
        for (int i=0, n=cars.getSize(); i < n; i++) {
            cars.updateCarMovement(i);
            String carState = cars.getCarState(i);
            System.out.println(carState);
        }
    }

    public static void printWinners(Winners winners) {
        System.out.println(winners.getWinners() + " 가 우승했습니다!");
    }
}
