package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("생성된 난수가 이동 기준을 만족할 때 위치가 1 증가한다.")
    void moveTest() {
        final Car car = new Car("pedro");
        final int randomNumber = 4;

        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("생성된 난수가 이동 기준을 만족하지 않을 때 위치는 변하지 않는다.")
    void notMoveTest() {
        final Car car = new Car("moly");
        final int randomNumber = 3;

        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 현재 위치를 우승자의 위치와 비교하여 우승자를 판정한다.")
    void isWinnerTest() {
        final Car car = new Car("moly");
        final int movePosition = 4;
        final int winnerPosition = 3;

        car.move(movePosition);
        car.move(movePosition);
        car.move(movePosition);

        assertThat(car.isWinner(winnerPosition)).isTrue();
    }

    @Test
    @DisplayName("자동차의 현재 위치를 우승자의 위치와 비교하여 우승자를 판정한다.")
    void isNotWinnerTest() {
        final Car car = new Car("moly");
        final int winnerPosition = 3;

        assertThat(car.isWinner(winnerPosition)).isFalse();
    }
}
