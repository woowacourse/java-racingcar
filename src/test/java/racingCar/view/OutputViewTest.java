package racingCar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.domain.Player;

import java.util.ArrayList;
import java.util.List;

class OutputViewTest {
    private List<Player> players;

    @BeforeEach
    void setUp() {
        players = new ArrayList<>();
        players.add(new Player("pobi", 3));
        players.add(new Player("pobi2", 1));
        players.add(new Player("pobi3", 8));
    }

    @Test
    void printResult() {
        OutputView.printResult(players);
    }
}
