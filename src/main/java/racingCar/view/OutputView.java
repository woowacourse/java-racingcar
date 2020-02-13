package racingCar.view;

import racingCar.domain.PlayerInfoPair;

import java.util.List;

public class OutputView {
    public static void printResult(List<PlayerInfoPair> playerInfoPairs) {
        playerInfoPairs.forEach(System.out::println);
    }
}
