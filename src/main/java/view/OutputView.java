package view;

public class OutputView {
    private OutputView() {
    }

    public static void printResultNotice() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(final String result) {
        System.out.print(result);
    }

    public static void printWinners(final String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
