package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 랜덤숫자가_4이상일_때만_움직인다() {
        assertThat(car.shouldMove(0)).isFalse();
        assertThat(car.shouldMove(1)).isFalse();
        assertThat(car.shouldMove(2)).isFalse();
        assertThat(car.shouldMove(3)).isFalse();

        assertThat(car.shouldMove(4)).isTrue();
        assertThat(car.shouldMove(5)).isTrue();
        assertThat(car.shouldMove(6)).isTrue();
        assertThat(car.shouldMove(7)).isTrue();
        assertThat(car.shouldMove(8)).isTrue();
        assertThat(car.shouldMove(9)).isTrue();
    }

    @Test
    void 움직여야_할때_움직인다() {
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
