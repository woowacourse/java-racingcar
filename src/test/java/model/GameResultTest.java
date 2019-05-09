package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    List<Car> cars;
    List<String> winners;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        winners = new ArrayList<>();
    }

    @Test
    void 우승자추출_검사() {
        cars.add(new Car("coogy",5));
        cars.add(new Car("pobi",4));
        cars.add(new Car("jason",3));
        cars.add(new Car("nick",5));

        GameResult result = new GameResult();

        winners.add("coogy");
        winners.add("nick");

        assertThat(result.getWinners(cars)).isEqualTo(winners);
    }
}