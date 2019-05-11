package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    void registerCarNameAndGameRoundTest() {
        List<String> names = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        names.add("pobi");
        names.add("crong");

        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));

        GameResult.registerCarNameAndGameRound(names, 2);

        assertThat(GameResult.getCars()).isEqualTo(cars);
        assertThat(GameResult.getGameRound()).isEqualTo(2);
    }
}
