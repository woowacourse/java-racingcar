package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MovableStrategy;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.NonMovableStrategy;

class CarTest {

    private final MovingStrategy movableStrategy = new MovableStrategy();
    private final MovingStrategy nonMovableStrategy = new NonMovableStrategy();
    private Car car;

    @BeforeEach
    void init() {
        car = new Car("밀리", 0);
    }

    @Test
    @DisplayName("자동차 한 칸 전진 확인")
    void moveCheck() {
        car.move(movableStrategy);

        assertThat(car.isSamePosition(new Position(1))).isTrue();
    }

    @Test
    @DisplayName("자동차 정지 확인")
    void stopCheck() {
        car.move(nonMovableStrategy);

        assertThat(car.isSamePosition(new Position(0))).isTrue();
    }

    @Test
    @DisplayName("더 많이 이동한 자동차 위치 확인")
    void findGreaterPosition() {
        car.move(movableStrategy);
        car.move(movableStrategy);
        car.move(movableStrategy);

        assertThat(car.findGreaterPosition(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이름과 위치 반환 확인")
    void getResult() {
        car.move(movableStrategy);

        assertThat(car.getResult("-")).isEqualTo("밀리 : -");
    }

    @Test
    @DisplayName("우승자인지 확인")
    void isWinner() {
        int maxPosition = 2;

        car.move(movableStrategy);
        car.move(movableStrategy);

        assertThat(car.isWinner(maxPosition)).isTrue();
    }
}
