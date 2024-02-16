package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @DisplayName("가장 많이 움직인 자동차가 최종 우승자가 된다.")
    @Test
    void winnerTest() {
        Car kaki = Car.from("kaki");
        Car nak = Car.from("nak");
        Cars cars = new Cars(List.of(kaki, nak));
        nak.move(new FakeNumber(9));
        Winners winners = Winners.from(cars);
        assertThat(winners.getWinners())
                .containsExactly("nak");
    }
}
