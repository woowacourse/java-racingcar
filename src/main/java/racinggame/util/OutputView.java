package racinggame.util;

import java.util.List;

public class OutputView {

    public static void showWinners(List<String> winners) {
        String winnerMessage = String.join(", ", winners.toArray(new String[winners.size()]));

        System.out.println(winnerMessage + "가 최종 우승했습니다.");
    }

    public static void showRaceResult(String carName, int carPosition) {
        StringBuilder carNameAndPositionView = new StringBuilder(carName);

        carNameAndPositionView.append(" : ");
        for (int i = 0 ; i < carPosition; i++) {
            carNameAndPositionView.append('-');
        }
        System.out.println(carNameAndPositionView);
    }
}