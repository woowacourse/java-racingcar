package racing.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class RacingCarsTest {

    @Test
    public void 우승자_확인() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("a",1));
        cars.add(new Car("b", 3));
        cars.add(new Car("c", 3));

        List<String> winners = Arrays.asList("b","c");

        RacingCars rc = new RacingCars(cars);

        assertEquals(winners,rc.getWinners());
    }
}
