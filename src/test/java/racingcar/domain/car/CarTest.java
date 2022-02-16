package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    public static final String SAMPLE_NAME = "pobi";
    public static final int MOVE_OPTION = 1;
    public static final int STOP_OPTION = 0;

    private Car testCar;

    @BeforeEach
    void setUp() {
        testCar = new Car(new Name(SAMPLE_NAME), new Position());
    }

    @DisplayName("자동차가 정상적으로 생성되는지 확인")
    @Test
    void createCar() {
        Name name = new Name(SAMPLE_NAME);
        Car car = new Car(name);

        assertThat(car).isEqualTo(testCar);
    }

    @DisplayName("자동차가 정상적으로 전진하는지 확인")
    @Test
    void Should_SuccessToMove() {
        testCar.move(() -> MOVE_OPTION);
        assertThat(testCar.getPosition()).isEqualTo(MOVE_OPTION);
    }

    @DisplayName("자동차가 정상적으로 정지하는지 확인")
    @Test
    void Should_SuccessToStop() {
        testCar.move(() -> STOP_OPTION);
        assertThat(testCar.getPosition()).isEqualTo(STOP_OPTION);
    }

    @Test
    void Should_FailToCreateCarPosition_Null() {
        Name name = new Name("pobi");
        assertThatThrownBy(() -> new Car(name, null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 위치는 null이 될 수 없습니다.");
    }

    @Test
    void Should_FailToCreateCarName_Null() {
        Position position = new Position(3);
        assertThatThrownBy(() -> new Car(null, position))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 null이 될 수 없습니다.");
    }
}
