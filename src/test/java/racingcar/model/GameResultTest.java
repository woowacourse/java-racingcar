package racingcar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    GameResult gameResult;
    final int maxDistance = 5;

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

    @Test
    void 우승자_판별_텍스트() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("honux"));
        carList.add(new Car("crong"));

        carList.get(0).setPosition(maxDistance);
        carList.get(1).setPosition(maxDistance);
        carList.get(2).setPosition(maxDistance-1);

        List<String> winner = new ArrayList<>();
        for(Car cars : carList){
           winner = gameResult.checkMaxPosition(cars,winner,maxDistance);
        }

        String result = String.join(",",winner);
        assertThat(result).isEqualTo("pobi,honux");

    }

    @AfterEach
    void tearDown() {
        gameResult = null;
    }
}
