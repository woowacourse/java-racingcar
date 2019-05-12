package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    void create() {
        List<String> names = new ArrayList<>();

        names.add("pobi");
        names.add("crong");

        assertThat(new GameResult(names, 2)).isEqualTo(new GameResult(names, 2));
    }

    @Test
    void decideMaxPositionCarTest() {
        GameResult gameResult = new GameResult(Arrays.asList("pobi", "crong"), 2);
        Car car = new Car("pobi");

        car.move(4);
        gameResult.getCars().get(0).move(4);

        assertThat(gameResult.decideMaxPositionCar()).isEqualTo(car);
    }
}
