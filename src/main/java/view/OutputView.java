package view;

public class OutputView {
    public static void printRacingStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printResult(String name, int moveNumber) {
        System.out.printf("%s : %s", name, "-".repeat(moveNumber));
        System.out.println();
    }
}
