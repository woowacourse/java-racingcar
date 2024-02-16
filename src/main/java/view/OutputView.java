package view;

import java.util.StringJoiner;
import model.Car;
import model.Race;

public class OutputView {
    private static final String OUTPUT_RESULT_MESSAGE = "\n실행 결과";

    public void printRaceResult(Race race) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        printRoundResult(race);
    }

    private void printRoundResult(Race race) {
        StringBuilder roundResult = new StringBuilder();

        for (Car car : race.getCars()) {
            roundResult.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getDistance()))
                    .append("\n");
        }

        System.out.println(roundResult);
    }

    public void printWinners(Race race) {
        System.out.println(generateWinnerString(race));
    }

    private StringJoiner generateWinnerString(Race race) {
        StringJoiner winners = new StringJoiner(", ", "", "가 최종 우승했습니다.");
        race.selectWinners().forEach(winners::add);
        return winners;
    }
}
