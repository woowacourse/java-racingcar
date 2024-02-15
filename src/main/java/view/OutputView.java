package view;

import java.util.List;
import java.util.StringJoiner;
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

    public static void showWinners(Race race) {
        List<String> winners = race.selectWinners();
        StringJoiner result = new StringJoiner(", ", "", "가 최종 우승했습니다.");
        for (String winner : winners) {
            result.add(winner);
        }
        System.out.println(result.toString());
    }
}
