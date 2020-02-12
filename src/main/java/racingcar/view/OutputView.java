package racingcar.view;

public class OutputView {
    private OutputView() {
    }

    public static void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }
    public static void askGameCounts() {
        System.out.println("시도 횟수를 입력해주세요.");
    }
}
