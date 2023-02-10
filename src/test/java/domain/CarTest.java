package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차는 ")
class CarTest {
    private Car car;

    @BeforeEach
    public void setup() {
        car = new Car(new Name("쥬니"));
    }

    @DisplayName("4 이상일 경우 전진한다.")
    @Test
    public void test1() {
        car.tryMove(4);

        Position position = new Position();
        position.move();

        Assertions.assertThat(car.getPosition())
                .isEqualTo(position);
    }

    @DisplayName("3 이하일 경우 전진하지 않는다.")
    @Test
    public void test2() {
        car.tryMove(3);

        Position position = new Position();

        Assertions.assertThat(car.getPosition())
                .isEqualTo(position);
    }
}