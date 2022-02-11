package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    public static final String SAMPLE_NAME = "pobi";

    private Car testCar;

    @BeforeEach
    void setUp() {
        testCar = new Car(new Name(SAMPLE_NAME), new Position());
    }

    @DisplayName("자동차가 정상적으로 생성되는지 확인")
    @Test
    void createCar() {
        Name name = new Name(SAMPLE_NAME);
        Position position = new Position();
        Car car = new Car(name, position);

        Assertions.assertThat(car).isEqualTo(testCar);
    }
}
