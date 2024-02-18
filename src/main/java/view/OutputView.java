package view;

import java.util.List;

public class OutputView {
    private OutputView() {}

    public static void printRacingStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printResult(String name, int moveNumber) {
        System.out.printf("%s : %s", name, "-".repeat(moveNumber));
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", winners));
    }
}
