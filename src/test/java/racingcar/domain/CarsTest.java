package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("경주할 자동차는 1대 이하일 경우에 IllegalArgumentException 발생")
    public void carsShouldBeMoreThanOneTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(Car.from("bmw"));

        assertThatThrownBy(() -> {
            Cars.from(cars);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("양쪽끝 공백을 제거한 자동차 이름이 서로 중복되면 IllegalArgumentException 발생")
    public void carsShouldNotUseDuplicatedNameTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(Car.from("bmw"));
        cars.add(Car.from(" bmw "));

        assertThatThrownBy(() -> {
            Cars.from(cars);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적으로 입력받은 값에 따라 자동차가 움직이는 지 테스트")
    public void tryToMove() {
        // given
        Cars cars = Cars.from(Arrays.asList(
            Car.from("톰"),
            Car.from("제리"),
            Car.from("포비"),
            Car.from("제이슨")
        ));
        List<Integer> values = new ArrayList<>();
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);

        List<Integer> expectedPositions = new ArrayList<>();
        expectedPositions.add(0);
        expectedPositions.add(0);
        expectedPositions.add(1);
        expectedPositions.add(1);

        // when
        cars.tryToMove(values);

        // then
        Result result = cars.getResult();
        List<CarState> carStates = result.getCarStates();
        for (int i = 0; i < carStates.size(); i++) {
            int actualPosition = carStates.get(i).getPosition();
            int expectedPosition = expectedPositions.get(i);
            assertThat(actualPosition).isEqualTo(expectedPosition);
        }
    }
}
