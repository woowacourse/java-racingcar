import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.Car;
import domain.Winner;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WinnerTest {
    static Car car1;
    static Car car2;
    static Car car3;
    static Winner winner;

    @BeforeAll
    static void setup() {
        car1 = new Car("jerry");
        car2 = new Car("jena");
        car3 = new Car("poby");
        List<Car> cars = new ArrayList<>();

        winner = new Winner();
        for (int i = 0; i < 5; i++) {
            car1.move(4);
            car3.move(4);
        }
        car2.move(4);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        winner.findWinnerNames(cars);
    }

    @Test
    void findWinnerNamesTest() {
        assertThat(winner.getWinnerNames().toArray())
                .containsExactly(car1.getName(), car3.getName());
    }

    @Test
    void testToString() {
        assertThat(winner.toString()).contains(car3.getName());
    }
}