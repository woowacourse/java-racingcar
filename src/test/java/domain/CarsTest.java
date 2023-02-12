package domain;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import strategy.FixedMovingStrategy;

class CarsTest {

    Cars cars;

    FixedMovingStrategy fixedMovingStrategy = new FixedMovingStrategy();

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of(new Car("joy"), new Car("pobi")));
        cars.moveCars(fixedMovingStrategy);
    }

    @Test
    void getTotalStatus() {
        assertEquals(
            cars.getTotalStatus(),
            List.of("joy : -",
                "pobi : -")
        );
    }

    @Test
    void findWinnersTest() {
        List<String> expected = List.of("joy", "pobi");
        assertEquals(expected, cars.findWinners());
    }
}