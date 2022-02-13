package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsStatusTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("pobi", () -> true));
        cars.add(new Car("crong", () -> true));
        cars.add(new Car("honux", () -> true));
    }

    @DisplayName("정상적인 Car 리스트가 주어지면 정상적으로 생성된다.")
    @Test
    void constructor_정상() {
        // given & when & then
        assertThatCode(() -> new CarsStatus(cars)).doesNotThrowAnyException();
    }

    @DisplayName("차 이동 후 상태 메시지를 확인한다.")
    @Test
    void makeCarsStatus_이동후_상태() {
        // given
        for (Car car : cars) {
            car.move();
        }

        // when
        CarsStatus carsStatus = new CarsStatus(cars);

        // then
        assertThat(carsStatus.makeCarsStatus()).isEqualTo("pobi : -\ncrong : -\nhonux : -");
    }
}