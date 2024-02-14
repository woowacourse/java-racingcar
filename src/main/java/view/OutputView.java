package view;

public class OutputView {
    public static void printResultNotice() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(String result) {
        System.out.print(result);
    }

    public static void printWinners(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
