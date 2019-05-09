package racinggame.util;

import java.util.List;

public class OutputView {

    public static void showWinners(List<String> winners) {

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