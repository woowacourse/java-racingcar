package view;

import domain.Cars;

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
        String winnerNames = winners.getFormattedAllNames();
        System.out.println(winnerNames + "(이)가 우승했습니다.");
    }

    public static void println() {
        System.out.println();
    }

    public static void printExceptionMsg(String msg) {
        System.out.println(msg);
    }
}
