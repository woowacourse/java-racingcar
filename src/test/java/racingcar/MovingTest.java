package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {

    @Test
    @DisplayName("자동차가 움직인다")
    public void car_move() {
        // given
        Car car = new Car("foo");

        // when & then
        assertThat(car.getPosition()).isEqualTo(0);
        car.moveOrHold(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 움직이지 않는다")
    public void car_not_move() {
        // given
        Car car = new Car("foo");

        // when & then
        assertThat(car.getPosition()).isEqualTo(0);
        car.moveOrHold(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("우승자가 한명일 때")
    public void Only_One_Winner() {
        // given
        Car car1 = new Car("foo");
        Car car2 = new Car("boo");
        Car car3 = new Car("bar");

        // when
        car1.moveOrHold(true);
        car1.moveOrHold(true);
        car1.moveOrHold(true);

        car2.moveOrHold(true);

        car3.moveOrHold(true);
        car3.moveOrHold(true);

        Game game = new Game(new InputView());
        game.setCars(car1, car2, car3);

        List<Car> winners = game.decideWinners();

        // then
        assertThat(winners).containsExactly(car1);
    }

    @Test
    @DisplayName("우승자가 여러일 때")
    public void Two_Or_More_Winners() {
        // given
        Car car1 = new Car("foo");
        Car car2 = new Car("boo");
        Car car3 = new Car("bar");

        // when
        car1.moveOrHold(true);
        car1.moveOrHold(true);
        car1.moveOrHold(true);

        car2.moveOrHold(true);

        car3.moveOrHold(true);
        car3.moveOrHold(true);
        car3.moveOrHold(true);

        Game game = new Game(new InputView());
        game.setCars(car1, car2, car3);

        List<Car> winners = game.decideWinners();

        // then
        assertThat(winners).containsExactly(car1, car3);
    }


}
