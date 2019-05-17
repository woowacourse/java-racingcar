package racingcar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    private GameResult gameResult;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("pobi", 5));
        carList.add(new Car("honux", 5));
        carList.add(new Car("crong", 4));

        gameResult = new GameResult(carList);
    }

    @Test
    void 우승자_판별_테스트() {
        List<String> winner = gameResult.racingResult();
        assertThat(String.join(",", winner)).isEqualTo("pobi,honux");
    }

    @AfterEach
    void tearDown() {
        gameResult = null;
    }
}
