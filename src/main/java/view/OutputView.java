package view;

import static constant.Messages.*;

import domain.Car;
import java.util.List;

public class OutputView {

    public static void printCarNames() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public static void printRound() {
        System.out.println(INPUT_ROUND);
    }

    public static void printRoundResult() {
        System.out.println(GAME_RESULT);
    }

    public static void printScore(List<Car> carList) {
        // toString override vs getter 사용 고민해보기
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getScore()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + WIN_THE_GAME);
    }
}
