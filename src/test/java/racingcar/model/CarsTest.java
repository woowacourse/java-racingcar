package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("등록된 모든 자동차들의 움직임을 시도하고 그 수만큼 결과를 반환한다.")
    @Test
    void confirmTryMoveAll() {
        //given
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Cars cars = new Cars(List.of(car1, car2));

        //when
        Map<Car, Integer> result = cars.tryMoveAll();

        //then
        assertThat(result).hasSize(2);
    }

    @DisplayName("등록된 자동차들의 위치 중 가장 높은 값을 반환한다.")
    @Test
    void getMaxPosition() {
        //given
        Car car1 = new Car("a", 0);
        Car car2 = new Car("b", 1);
        Cars cars = new Cars(List.of(car1, car2));

        //when
        int maxPosition = cars.getMaxPosition();

        //then
        assertThat(maxPosition).isEqualTo(1);
    }

    @DisplayName("인자로 전달된 값과 동일한 위치값을 가진 자동차를 반환한다.")
    @Test
    void getCarsByPosition() {
        //given
        Car car1 = new Car("a", 0);
        Car car2 = new Car("b", 1);
        Car car3 = new Car("c", 1);
        Cars cars = new Cars(List.of(car1, car2, car3));

        int position = 1;

        //when
        List<Car> carsByPosition = cars.getCarsByPosition(position);

        //then
        assertThat(carsByPosition).containsExactly(car2, car3);
    }
}