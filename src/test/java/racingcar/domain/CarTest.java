package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    public void moveCar() {
        final Name name = new Name("중간곰");
        final Car movedCar = new Car(name).moveDefinitely();
        final Car expected = new Car(name, Position.from(1));

        assertThat(movedCar)
                .isEqualTo(expected);
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
}
