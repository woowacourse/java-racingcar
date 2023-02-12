package view;

import java.util.List;

public class OutputView {

    private final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String ENTER_TRY_TIMES = "시도할 회수는 몇회인가요?";
    private final String RESULT = "실행 결과";
    private final String FINAL_WINNER = "%s가 최종 우승했습니다.";

    public void printInputCarNamesNotice() {
        System.out.println(ENTER_CAR_NAME);
    }

    public void printInputTryTimesNotice() {
        System.out.println(ENTER_TRY_TIMES);
    }

    public void printResultNotice() {
        System.out.println(RESULT);
    }

    public void printSingleRoundResult(List<String> subResult) {
        for (String carStatus : subResult) {
            System.out.println(carStatus);
        }
        System.out.println();
    }

    public void printWinner(String winners) {
        System.out.printf(FINAL_WINNER, winners);
    }
}
