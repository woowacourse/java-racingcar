package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
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
}
