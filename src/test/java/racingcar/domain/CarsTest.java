package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    public void 경주할_자동차는_1대_이하일_경우에_IllegalArgumentException_발생() {
        List<Car> cars = new ArrayList<>();
        cars.add(Car.of("bmw"));

        assertThatThrownBy(() -> {
            Cars.of(cars);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 양쪽끝_공백을_제거한_자동차_이름이_서로_중복되면_IllegalArgumentException_발생() {
        List<Car> cars = new ArrayList<>();
        cars.add(Car.of("bmw"));
        cars.add(Car.of(" bmw "));

        assertThatThrownBy(() -> {
            Cars.of(cars);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
