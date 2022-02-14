package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("랜덤값이 전진 조건값 이상일 경우 한칸 전진")
    public void carShouldMove() {
        Car car = new Car("woo");
        int beforeMove = car.getPosition();

        car.moveOrNot(8);

        assertThat(car.getPosition())
                .isEqualTo(beforeMove + 1);
    }

    @Test
    @DisplayName("랜덤값이 전진 조건값 미만일 경우 전진하지 않음")
    public void carShouldNotMove() {
        Car car = new Car("woo");
        int beforeMove = car.getPosition();

        car.moveOrNot(2);

        assertThat(car.getPosition())
                .isEqualTo(beforeMove);
    }

    @Test
    @DisplayName("최대 전진횟수와 동일한 전진횟수를 가지는 경우 우승자임을 반환")
    public void mustBeWinner() {
        Car car = new Car("woo");

        int maxPosition = car.getPosition() + 1;
        car.moveOrNot(8);

        assertThat(car.isSamePosition(maxPosition)).isTrue();
    }

    @Test
    @DisplayName("최대전진횟수와 동일하지 않는 전진횟수를 가지는 경우 우승자가 아님을 반환")
    public void mustNotBeWinner() {
        Car car = new Car("woo");

        int maxPosition = car.getPosition() + 2;
        car.moveOrNot(8);

        assertThat(car.isSamePosition(maxPosition)).isFalse();
    }

}