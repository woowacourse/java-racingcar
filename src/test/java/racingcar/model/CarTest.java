package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("Thor");
    }

    @Test
    public void move() {
        car.tryMove(5);
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @Test
    public void doNotMove() {
        car.tryMove(3);
        assertThat(car.getCarPosition()).isEqualTo(0);
    }

    @Test
    public void shouldBeWinner() {
        int winnerPosition = 0;
        boolean zeroPositionWinner = car.isSamePosition(winnerPosition);
        assertThat(zeroPositionWinner).isEqualTo(true);
    }

    @Test
    public void shouldNotBeWinner() {
        int winnerPosition = 1;
        boolean onePositionWinner = car.isSamePosition(winnerPosition);
        assertThat(onePositionWinner).isEqualTo(false);
    }
}