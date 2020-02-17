import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Names;
import racinggame.domain.Winners;

import java.util.List;

public class WinnersTest {
    private final Names names = new Names("pobi,crong,honux");
    private Cars cars = new Cars(names);
    private Winners winners;
    private String winnerName = "honux";

    @BeforeEach
    void initCarsPosition() {
        int i = 0;
        for (Car car : cars) {
            car.move(6);
            car.move(i);
            i += 3;
        }
    }

    @Test
    void makeWinnersTest() {
        winners = cars.makeWinners(2);
        List<String> winnerNames = winners.getWinners();
        Assertions.assertThat(winnerNames.contains(winnerName)).isTrue();
    }
}
