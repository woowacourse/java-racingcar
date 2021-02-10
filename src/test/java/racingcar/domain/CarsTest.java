package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsTest {
    private Cars cars;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        String carsName = "pobi, jun, aaa";
        cars = new Cars(new Racers(carsName));
        List<Car> allCars = cars.toList();
        car1 = allCars.get(0);
        car2 = allCars.get(1);
        car3 = allCars.get(2);
    }

    @Test
    @DisplayName("가장 멀리 전진한 자동차 찾기")
    void maxPositionCar() {
        MoveStrategy winnerMoveStrategy = () -> 5;
        MoveStrategy loserMoveStrategy = () -> 3;

        car1.move(winnerMoveStrategy);
        car2.move(loserMoveStrategy);
        car3.move(loserMoveStrategy);

        List<Car> winnerCars = cars.getWinnerCars();
        assertTrue(winnerCars.contains(car1));
    }
}
