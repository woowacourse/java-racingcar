package racingcar.view;

import racingcar.domain.result.Result;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printGameRoundGuide() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultGuide() {
        System.out.println("실행 결과");
    }

    public void printResult(Result result) {
        List<Map<String, Integer>> results = result.getResults();
        for (Map<String, Integer> roundResult : results) {
            for (String key : roundResult.keySet()) {
                String position = "-".repeat(roundResult.get(key));
                System.out.println(String.format("%s : %s", key, position));
            }
            System.out.println();
        }
    }

    public void printWinners(Result results) {
        String winner = String.join(", ", results.findWinners());
        System.out.println(String.format("%s가 최종 우승했습니다.", winner));
    }
}
