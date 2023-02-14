package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import domain.engine.ImmovableEngine;
import domain.engine.MovableEngine;

@DisplayName("자동차는 ")
class CarTest {
    private Car car;

    @DisplayName("4 이상일 경우 전진한다.")
    @Test
    public void moveForwardTest() {
        car = new Car(new Name("쥬니"), new MovableEngine());

        car.tryMove();

        Position position = new Position();
        position.move();

        Assertions.assertThat(car.getPosition())
                .isEqualTo(position);
    }

    @DisplayName("3 이하일 경우 전진하지 않는다.")
    @Test
    public void notMoveForwardTest() {
        car = new Car(new Name("쥬니"), new ImmovableEngine());

        car.tryMove();

        Position position = new Position();

        Assertions.assertThat(car.getPosition())
                .isEqualTo(position);
    }
}