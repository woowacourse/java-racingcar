package service;

import static org.junit.jupiter.api.Assertions.*;

import domain.Car;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServiceTest {

    @Test
    @DisplayName("우승자 판별 테스트")
    void getWinnerNames_validCase() {
        // given
        List<Car> cars = new ArrayList<>();
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        // when
        carB.move();
        carC.move();

        cars.add(carA);
        cars.add(carB);
        cars.add(carC);

        // then
        assertEquals(new ArrayList<>(List.of("carB", "carC")), Car.RacingGame.getWinnerNames(cars));
    }
}
