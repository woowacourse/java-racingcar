package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printCarPositionHistory(String[] carNames, ArrayList<Integer>[] carPositionHistory) {
        int numOfGame = carPositionHistory[0].size();
        System.out.println("\n실행 결과");
        for (int i = 0; i < numOfGame; i++) {
            for (int j = 0; j < carNames.length; j++) {
                printOneCarStatus(carNames[j], carPositionHistory[j].get(i));
            }
            System.out.println();
        }
    }

    private static void printOneCarStatus(String carName, int carPosition) {
        StringBuilder status = new StringBuilder();
        status.append(carName + " : ");
        for (int i = 0; i < carPosition; i++) {
            status.append("-");
        }
        System.out.println(status);
    }

    public static void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
