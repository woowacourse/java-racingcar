package view;

import domain.Car;
import domain.Winners;

import java.util.List;
import java.util.ArrayList;

public class OutputView {
    public static void printCurrentPosition(String name, int position) {
        String carState = String.format("%s : %s", name, makeHyphens(position));
        System.out.println(carState);
    }

    private static String makeHyphens(int position) {
        StringBuilder builder = new StringBuilder();
        while (position-- > 0) {
            builder.append("-");
        }
        return builder.toString();
    }

    public static void printWinners(Winners winners) {
        int winnerSize = winners.getSize();
        List<String> winnerNames = new ArrayList<>();

        for (int count = 0; count < winnerSize; count++) {
            Car winner = winners.getWinner(count);
            winnerNames.add(winner.getName());
        }
        System.out.println(String.join(",", winnerNames) + "(이)가 우승했씁니다.");
    }

    public static void println() {
        System.out.print("\n");
    }


}
