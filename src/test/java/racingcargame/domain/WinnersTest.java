package racingcargame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 최종우승자_추출() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 3));
        cars.add(new Car("jason", 1));
        cars.add(new Car("brown", 4));
        cars.add(new Car("coil", 4));
        // when
        Winners winners = Winners.extractWinners(cars);
        // then
        assertThat(winners.getValues()).contains(new Car("brown"), new Car("coil"));
        assertThat(winners.getValues()).hasSize(2);
    }


}