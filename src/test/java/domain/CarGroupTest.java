package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGroupTest {

    @Test
    @DisplayName("자동차 이름이 정상적으로 생성되는가")
    void cars_generation_test() {
        String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};

        CarGroup carGroup = new CarGroup(carNames);
        List<Car> expected = List.of(new Car("mang"), new Car("weve"), new Car("pobi"),
                new Car("neo"));

        assertThat(carGroup.getAllCars()).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("우승자가 정상적으로 반환되는가")
    void get_winners_test() {
        String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
        CarGroup carGroup = new CarGroup(carNames);

        List<Car> cars = carGroup.getAllCars();
        Car winner = cars.get(0);
        winner.move(9);

        assertThat(carGroup.getWinners()).containsExactly(winner);
    }

    @Test
    @DisplayName("우승자가 없는가")
    void no_winners_test() {
        String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
        CarGroup carGroup = new CarGroup(carNames);

        List<Car> cars = carGroup.getAllCars();
        Car winner = cars.get(0);
        winner.move(0);

        assertThat(carGroup.getWinners()).isEmpty();
    }
}
