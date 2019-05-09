package racingcar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
    }

    @Test
    void 최대거리_테스트() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("honux"));
        carList.add(new Car("crong"));

        carList.get(2).setPosition(5);
        carList.get(1).setPosition(3);
        int max = 0;

        for(int i = 0 ; i< carList.size() ; i++){
           max = gameResult.getMaxDistance(max, carList.get(i));
        }

        assertThat(max).isEqualTo(5);
    }

    @AfterEach
    void tearDown() {
        gameResult = null;
    }
}
