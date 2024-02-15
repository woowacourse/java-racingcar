package view;

import model.Car;
import model.Race;

public class OutputView {
    public static void showRaceResult() {
        System.out.println("\n실행 결과");
    }

    public static void showRoundResult(Race race) {
        StringBuilder roundResult = new StringBuilder();

        for (Car car : race.getCars()) {
            roundResult.append(car.getName())
                    .append(" : ")
                    .append(car.showDistance())
                    .append("\n");
        }

        System.out.println(roundResult);
    }

}
