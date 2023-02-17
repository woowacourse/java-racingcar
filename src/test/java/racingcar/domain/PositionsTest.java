package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PositionsTest {
    private static Positions positions;
    private RandomNumberPicker randomNumberPicker;

    @BeforeEach
    void setUp() {
        randomNumberPicker = new RandomNumberPicker();
        positions = new Positions("judy,nunu,pobi", randomNumberPicker);
    }

    @Test
    void move_함수를_호출했을때_진행이_되는_것을_확인() {
        List<Car> cars = positions.getCars();

        positions.moveCar(cars.get(0), 5);
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(0).getCarName()).isEqualTo("judy");

        positions.moveCar(cars.get(1), 1);
        assertThat(cars.get(1).getPosition()).isZero();
        assertThat(cars.get(1).getCarName()).isEqualTo("nunu");

        positions.moveCar(cars.get(2), 7);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getCarName()).isEqualTo("pobi");
    }

    @Test
    void findWinner_함수로_우승자들이_반환됨() {
        positions.moveCar(positions.getCars().get(0), 5);
        positions.moveCar(positions.getCars().get(2), 7);

        assertThat(positions.findWinner()).containsExactly("judy", "pobi");
    }
}
