package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.movingstrategy.DefinitelyMovingStrategy;
import racingcar.domain.movingstrategy.SwitchedMovingStrategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @DisplayName("동등 비교")
    @Test
    public void equals() {
        final String nameValue = "중간곰";
        final int positionValue = 10;

        final Car car = new Car(new Name(nameValue), Position.from(positionValue));
        final Car expected = new Car(new Name(nameValue), Position.from(positionValue + 1));

        assertThat(car)
                .isEqualTo(expected);
    }

    @DisplayName("자동차 전진 성공")
    @Test
    public void moveDefinitely() {
        final Name name = new Name("중간곰");
        final Position position = Position.from(0);
        final Position expected = Position.from(1);

        Car car = new Car(name, position, DefinitelyMovingStrategy.getInstance());
        car = car.move();

        assertThat(car.isSamePosition(expected))
                .isTrue();
    }

    @DisplayName("위치 비교")
    @Test
    public void compareTo() {
        final Name name = new Name("중간곰");
        final Car nearCar = new Car(name);
        final Car farCar = new Car(name, Position.from(10));

        final int compareResult = farCar.compareTo(nearCar);
        assertThat(compareResult).isEqualTo(1);
    }

    @DisplayName("번갈아가며 자동차 전진")
    @ParameterizedTest
    @ValueSource(ints = {10, 11, 50, 101, 200})
    public void moveUsedSwitchedPattern(final int movingCount) {
        final Name name = new Name("중간곰");
        final Position position = Position.from(0);
        final SwitchedMovingStrategy switchedMovingStrategy = new SwitchedMovingStrategy();
        final Position expected = Position.from(movingCount / 2);
        Car car = new Car(name, position, switchedMovingStrategy);

        for (int i = 0; i < movingCount; i++) {
            car = car.move();
        }

        assertThat(car.isSamePosition(expected))
                .isTrue();
    }
}
