package application.racing.view;

import application.racing.domain.Car;
import application.racing.domain.Cars;

import java.util.List;

public class OutputViewer {
    private final static String RUN_RESULT = "\n실행 결과";
    private final static String COLON = " : ";
    private final static String BAR = "-";
    private final static String WINNER_MENTION = "가 최종 우승했습니다.";
    private final static String NAME_DELIMITER = ", ";

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printRacingResultMessage() {
        System.out.println(RUN_RESULT);
    }

    public static void printPositionDuringRace(Cars cars) {
        for (Car car : cars.getCars()) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.toString());
            sb.append(COLON);
            System.out.print(sb.toString());
            printCarPositionUsingBar(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printCarPositionUsingBar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(BAR);
        }
    }

    public static void printWinner(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        String winnerNameString = makeWinnerNameString(winners);
        sb.append(winnerNameString);
        sb.append(WINNER_MENTION);
        System.out.println(sb.toString());
    }

    private static String makeWinnerNameString(List<String> winners) {
        return String.join(addCommaWithBlank(), winners);
    }

    private static String addCommaWithBlank() {
        StringBuilder sb = new StringBuilder();
        sb.append(NAME_DELIMITER);
        return sb.toString();
    }
}
