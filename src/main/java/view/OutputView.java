package view;

import domain.Car;
import domain.Cars;

import java.util.List;
import java.util.ArrayList;

public class OutputView {
    private static final char MOVE_SIGN = '-';

    public static void printCurrentPosition(String name, int position) {
        String carState = String.format("%s : %s", name, makeMoveSigns(position));
        System.out.println(carState);
    }

    private static String makeMoveSigns(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(MOVE_SIGN);
        }
        return builder.toString();
    }

    public static void printWinners(Cars winners) {
        int winnerSize = winners.getSize();
        List<String> winnerNames = new ArrayList<>();
        for (int count = 0; count < winnerSize; count++) {
            Car winner = winners.getCar(count);
            winnerNames.add(winner.getName());
        }
        String formattedName = String.join(",", winnerNames);
        System.out.println(formattedName + "(이)가 우승했습니다.");
    }

    public static void println() {
        System.out.println();
    }

    public static void printExceptionMsg(String msg) {
        System.out.println(msg);
    }
}
