package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car testCar;

    @BeforeEach
    void setUp() {
        testCar = new Car(new Name("pobi"), new Position());
    }

    @Test
    void createCar() {
        Name name = new Name("pobi");
        Position position = new Position();
        Car car = new Car(name, position);

        Assertions.assertThat(car).isEqualTo(testCar);
    }

    @Test
    @DisplayName("null 값으로 car 를 생성할수 없다.")
    public void errorOnCreatingCarWithNullValue() {
        Assertions.assertThatThrownBy(() -> new Car(null, null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testIsSamePositionWithDefault() {
        Car car = new Car("pobi");
        Assertions.assertThat(car.isSamePosition(0)).isTrue();
    }

    @Test
    void testIsSamePositionWithValue() {
        Car car = new Car(new Name("pobi"), new Position(3));
        Assertions.assertThat(car.isSamePosition(3)).isTrue();
    }

}
