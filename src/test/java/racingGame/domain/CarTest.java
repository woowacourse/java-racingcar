package racingGame.domain;

import org.junit.jupiter.api.Test;
import racingGame.utils.ImmovableNumberGenerator;
import racingGame.utils.MovableNumberGenerator;
import racingGame.utils.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int MOVING_UNIT = 1;

    @Test
    void move_랜덤_값이_3_이하() {
        Car car = new Car(new Name("test"));
        NumberGenerator numberGenerator = new ImmovableNumberGenerator();
        final int initPosition = car.getPosition();

        car.move(numberGenerator.generateNumber());
        final int actual = car.getPosition();

        final int expected = initPosition;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void move_랜덤_값이_4_이상() {
        Car car = new Car(new Name("test"));
        NumberGenerator numberGenerator = new MovableNumberGenerator();
        final int initPosition = car.getPosition();

        car.move(numberGenerator.generateNumber());
        final int actual = car.getPosition();

        final int expected = initPosition + MOVING_UNIT;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void isWinnerPosition_우승한_위치의_자동차() {
        Car car = new Car(new Name("test"));
        NumberGenerator numberGenerator = new MovableNumberGenerator();
        final int winnerPosition = 2;

        car.move(numberGenerator.generateNumber());
        car.move(numberGenerator.generateNumber());

        assertThat(car.isSamePosition(winnerPosition)).isTrue();
    }

    @Test
    void isWinnerPosition_우승하지_못한_위치의_자동차() {
        Car car = new Car(new Name("test"));
        NumberGenerator numberGenerator = new MovableNumberGenerator();
        final int winnerPosition = 2;

        car.move(numberGenerator.generateNumber());

        assertThat(car.isSamePosition(winnerPosition)).isFalse();
    }
}
