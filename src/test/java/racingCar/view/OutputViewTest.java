package racingCar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.domain.PlayerInfoPair;

import java.util.ArrayList;
import java.util.List;

class OutputViewTest {
    private List<PlayerInfoPair> playerInfoPairs;

    @BeforeEach
    void setUp() {
        playerInfoPairs = new ArrayList<>();
        playerInfoPairs.add(new PlayerInfoPair("pobi", 3));
        playerInfoPairs.add(new PlayerInfoPair("pobi2", 1));
        playerInfoPairs.add(new PlayerInfoPair("pobi3", 8));
    }

    @Test
    void printResult() {
        OutputView.printResult(playerInfoPairs);
    }
}
