package racingCar.view;

import racingCar.domain.PlayerInfoPair;

import java.util.List;

public class OutputView {
    private static final String RESULT_HEAD = "실행 결과";
    public static void printResult(List<PlayerInfoPair> playerInfoPairs) {
        System.out.println(RESULT_HEAD);
        playerInfoPairs.forEach(System.out::println);
    }
}
