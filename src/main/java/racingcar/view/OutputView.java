package racingcar.view;

public class OutputView {
    public static void showResult() {
        System.out.println("\n실행 결과");
    }

    public static void showEachRaceResult(String eachRaceResult) {
        System.out.println(eachRaceResult);
    }

    public static void showWinners(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}