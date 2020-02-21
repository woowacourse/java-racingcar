package racingcargame.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    static List<Car> cars = new ArrayList<>();

    @BeforeAll
    static void initialize() {
        cars.add(new Car("pobi", 3));
        cars.add(new Car("jason", 1));
        cars.add(new Car("brown", 4));
        cars.add(new Car("coil", 4));
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 최종우승자_추출() {
        // given
        // when
        Winners winners = Winners.extractWinners(cars);
        // then
        assertThat(winners.getValues()).contains(new Car("brown"), new Car("coil"));
        assertThat(winners.getValues()).hasSize(2);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 최종우승자_이름_추출() {
        // given
        // when
        Winners winners = Winners.extractWinners(cars);
        // then
        assertThat(winners.getNames()).contains("brown", "coil");
        assertThat(winners.getNames()).doesNotContain("pobi", "jason");
        assertThat(winners.getValues()).hasSize(2);
    }
}