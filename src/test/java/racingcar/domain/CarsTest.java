package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {

    @Test
    @DisplayName("가장 멀리 전진한 자동차 찾기")
    void maxPositionCar() {
        String carsName = "pobi, jun, aaa";
        Cars cars = new Cars(new Racers(carsName));
        List<Car> carList = cars.toList();

        MoveStrategy winnerMoveStrategy = () -> 5;
        MoveStrategy loserMoveStrategy = () -> 3;

        carList.get(0).move(winnerMoveStrategy);
        carList.get(1).move(loserMoveStrategy);
        carList.get(2).move(loserMoveStrategy);

        assertEquals(carList.get(0), cars.getMaxPositionCar());
    }
}
