package application.racing.view;

import application.racing.ConstantForRacing;
import application.racing.domain.Car;

import java.util.List;

public class OutputViewer {
    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printRacingResultMessage() {
        System.out.println(ConstantForRacing.RESULT_STRING);
    }

    public void printPositionDuringRacing(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(addCarNameStringWithColon(car));
            printCarPositionUsingBar(car);
            System.out.println();
        }
        System.out.println();
    }

    private String addCarNameStringWithColon(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(ConstantForRacing.COLON_STRING);
        return sb.toString();
    }

    private void printCarPositionUsingBar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(ConstantForRacing.BAR_STRING);
        }
    }

    public static void printWinner(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        String winnerNameString = makeWinnerNameString(winners);
        sb.append(winnerNameString);
        sb.append(ConstantForRacing.WINNER_STRING);
        System.out.println(sb.toString());
    }

    private static String makeWinnerNameString(List<String> winners) {
        return String.join(addCommaWithBlank(), winners);
    }

    private static String addCommaWithBlank() {
        StringBuilder sb = new StringBuilder();
        sb.append(ConstantForRacing.NAME_DELIMITER);
        sb.append(ConstantForRacing.BLANK_STRING);
        return sb.toString();
    }
}
