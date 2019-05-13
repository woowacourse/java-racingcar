package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    Winner winner;
    List<Car> cars;

    @Test
    void 우승자_한명_결과_확인() {
        Car[] carsArr = {new Car("pobi", 3), new Car("slo", 2)};
        cars = Arrays.asList(carsArr);
        winner = new Winner(cars);
        String result = winner.toString();
        assertThat(result).isEqualTo("pobi");
    }

    @Test
    void 우승자_두명_결과_확인() {
        Car[] carsArr = {new Car("pobi", 3), new Car("slo", 2), new Car("ho",3)};
        cars = Arrays.asList(carsArr);
        winner = new Winner(cars);
        String result = winner.toString();
        assertThat(result).isEqualTo("pobi ho");
    }

}
