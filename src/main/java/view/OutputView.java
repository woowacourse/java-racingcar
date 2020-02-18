package view;

import domain.Cars;

import java.awt.*;
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
        List<String> names = new ArrayList<String>();
        for (int count = 0; count < winners.getSize(); count++) {
            names.add(winners.get(count).getName());
        }
        String winnerNames = String.join(",", names);
        System.out.println(winnerNames + "(이)가 우승했습니다.");
    }

    public static void println() {
        System.out.println();
    }

    public static void printExceptionMsg(String msg) {
        System.out.println(msg);
    }
}
