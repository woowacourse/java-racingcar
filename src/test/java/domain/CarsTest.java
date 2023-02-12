package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class CarsTest {

    @Test
    @DisplayName("getWinner() : 가장 많이 움직인 자동차를 반환해준다.")
    void test_getWinner() {
        // given
        final Car pobi = createCar("pobi");
        pobi.move();
        pobi.move();

        final Car crong = createCar("crong");
        crong.move();

        Cars cars = new Cars(List.of(pobi, crong));

        // when
        List<Car> result = cars.getWinner();

        // then
        assertThat(result).extracting("name")
                          .contains(pobi.getName());
    }

    private Car createCar(String name) {
        return new Car(name);
    }


    @Test
    @DisplayName("getCurrentStatus() : 현재 움직인 거리를 보여준다.")
    void test_getCurrentStatus() {
        // given
        final Car pobi = createCar("pobi");
        pobi.move();
        pobi.move();

        final Car crong = createCar("crong");
        crong.move();

        Cars cars = new Cars(List.of(pobi, crong));

        // when
        final Map<String, Integer> carCurrentStatus = cars.getCurrentStatus();

        // then
        assertThat(carCurrentStatus).hasSize(2)
                                    .contains(entry("pobi", 2), entry("crong", 1));
    }
}
