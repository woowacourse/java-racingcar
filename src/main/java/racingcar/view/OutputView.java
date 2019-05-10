package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Winner;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";
    private static final String EMPTY_STRING = "";
    private static final String SPACE_AND_COMMA = " ,";
    private static final String WINNER_MENT = "가 최종 우승했습니다.";
    private static final String RESULT_MENT = "실행결과";

    public static void printCarState(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName() + COLON);
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(HYPHEN);
        }
        System.out.println(sb.toString());
    }

    public static void printEmptyLine() {
        System.out.println(EMPTY_STRING);
    }

    public static void printWinners(Winner winner) {
        List<Car> winnersOfRacing = winner.getWinners();
        List<String> winners = new ArrayList<>();
        for (Car winnerOfRacing : winnersOfRacing) {
            winners.add(winnerOfRacing.getName());
        }
        System.out.println(String.join(SPACE_AND_COMMA, winners) + WINNER_MENT);
    }

    public static void printResultMent() {
        System.out.println(RESULT_MENT);
    }
}
