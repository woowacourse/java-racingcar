package racingcar.view;

import racingcar.domain.Winners;

public class OutputView {
    private OutputView() {
    }

    public static void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void askTrial() {
        System.out.println("시도 횟수를 입력해주세요.");
    }

    public static void printCurrentResultTitle() { System.out.println("실행 결과"); }

    public static void printCurrentResult(String result) { System.out.println(result); }

    public static void printWinnerResult() {
        System.out.println(Winners.getWinners() + "가 최종 우승했습니다.");
    }

    public static void printErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }
}
