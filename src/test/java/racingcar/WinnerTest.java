package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerTest {

    @DisplayName("공동 우승자 테스트")
    @Test
    void winnerTest() {
        Car a = new Car(new CarName("a"));
        Car b = new Car(new CarName("b"));
        Car c = new Car(new CarName("c"));
        a.moveForwardByNumber(5);
        b.moveForwardByNumber(5);

        Cars cars = new Cars(Arrays.asList(a,b,c));
        assertEquals(cars.getWinners().size(), 2);
    }
}
