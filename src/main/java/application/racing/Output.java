package application.racing;

import java.util.List;

public class Output {
    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printRacingResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printPositionDuringRacing(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printCarPositionUsingBar(car);
            System.out.println();
        }
        System.out.println();
    }

    private void printCarPositionUsingBar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static void printWinner(List<String> winners) {
        String winnerNameString = makeWinnerNameString(winners);
        System.out.println(winnerNameString + "가 최종 우승했습니다.");
    }

    private static String makeWinnerNameString(List<String> winners) {
        return String.join(", ", winners);
    }
}
