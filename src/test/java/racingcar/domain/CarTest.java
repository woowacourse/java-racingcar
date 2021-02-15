package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @DisplayName("동등 비교")
    @Test
    public void equals() {
        final Name name = new Name("중간곰");
        final Car car = new Car(name);

        assertThat(car)
                .isEqualTo(new Car(name));
    }

    @DisplayName("자동차 전진 성공")
    @Test
    public void moveCar() {
        final Name name = new Name("중간곰");
        final Car movedCar = new Car(name).move();
        final Car expected = new Car(name, new Position(1));

        assertThat(movedCar)
                .isEqualTo(expected);
    }

    @DisplayName("위치 비교")
    @Test
    public void compareTo() {
        final Name name = new Name("중간곰");
        final Car nearCar = new Car(name);
        final Car farCar = new Car(name, new Position(10));

        final int compareResult = farCar.compareTo(nearCar);
        assertThat(compareResult).isEqualTo(1);
    }
}
