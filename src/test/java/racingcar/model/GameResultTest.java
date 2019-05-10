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
//        List<Car> carList = new ArrayList<>();
//        carList.add(new Car("pobi",5));
//        carList.add(new Car("honux",3));
//        carList.add(new Car("crong",5));
//        int maxDistance = 0;
//
//        for(Car car : carList){
//            maxDistance = gameResult.getMaxDistance(maxDistance, car);
//        }
//
//        assertThat(maxDistance).isEqualTo(5);
    }

    @Test
    void 우승자_판별_테스트() {
//        List<Car> carList = new ArrayList<>();
//        carList.add(new Car("pobi",5));
//        carList.add(new Car("honux",5));
//        carList.add(new Car("crong",4));
//
//        List<String> winner = new ArrayList<>();
//        for(Car cars : carList){
//           winner = gameResult.checkMaxPosition(cars,winner,maxDistance);
//        }
//
//        assertThat(String.join(",",winner)).isEqualTo("pobi,honux");
    }

    @AfterEach
    void tearDown() {
        gameResult = null;
    }
}
