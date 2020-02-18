import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Names;
import racinggame.domain.Winners;

import java.util.ArrayList;
import java.util.List;

public class WinnersTest {
    private Cars cars;
    private Winners winners;
    private String winnerName = "crong";

    @BeforeEach
    void initList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", 4));
        carList.add(new Car("crong", 7));
        carList.add(new Car("honux", 3));
        cars = new Cars(carList);
    }

    @Test
    void makeWinnersTest() {
        winners = cars.makeWinners(7);
        List<String> winnerNames = winners.getWinners();
        Assertions.assertThat(winnerNames.contains(winnerName)).isTrue();
        Assertions.assertThat(winnerNames.contains("pobi")).isFalse();
        Assertions.assertThat(winnerNames.contains("honux")).isFalse();
    }
}
