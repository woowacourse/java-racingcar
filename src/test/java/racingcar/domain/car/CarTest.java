package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
}
