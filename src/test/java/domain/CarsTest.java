package domain;

import static org.assertj.core.api.AssertionsForClassTypes.tuple;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    @DisplayName("getStatueses 메서드는 Cars의 상태를 반환한다.")
    void getStatusesTest() {
        Car hong = new Car("hong", 1);
        Car rosie = new Car("rosie", 4);
        final Cars cars = new Cars(List.of(hong, rosie));

        final List<Car> statuses = cars.getStatuses();

        Assertions.assertThat(statuses)
                .extracting("name", "position")
                .containsExactly(tuple("hong", 1), tuple("rosie", 4));
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있으면 Exception을 발생시킨다.")
    void throwExceptionWhenCarsHasDuplicate() {
        final List<Car> cars = List.of(new Car("hong"), new Car("hong"));

        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .hasMessage("자동차 이름은 중복일 수 없습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}
