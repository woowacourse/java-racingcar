package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("getWinner() : 가장 많이 움직인 자동차를 반환해준다.")
    void test_getWinner() {
        // given
        final Car pobi = new Car("pobi");
        pobi.move();
        pobi.move();

        final Car crong = new Car("crong");
        crong.move();

        Cars cars = new Cars(List.of(pobi, crong));

        // when
        List<String> result = cars.getWinner();

        // then
        assertThat(result).containsOnly(pobi.getName());
        assertThat(result.size()).isEqualTo(1);
        assertThat(result).doesNotContain(crong.getName());
    }

    @Test
    @DisplayName("getCurrentStatus() : 현재 움직인 거리를 보여준다.")
    void test_getCurrentStatus() {
        // given
        final Car pobi = new Car("pobi");
        pobi.move();
        pobi.move();

        final Car crong = new Car("crong");
        crong.move();

        final Cars cars = new Cars(List.of(pobi, crong));

        // when
        final Map<String, Integer> carCurrentStatus = cars.getCurrentStatus();

        // then
        assertThat(carCurrentStatus).hasSize(2)
                .contains(entry("pobi", 2), entry("crong", 1));
    }
}
