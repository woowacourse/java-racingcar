package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {
    @Test
    @DisplayName("우승자를 구한다.")
    void getWinners() {
        final Car pobi = Car.of("pobi", 2);
        final Car kirby = Car.of("kirby", 4);
        final Car jonge = Car.of("jonge", 4);

        final Winners winners = Winners.from(Cars.from(List.of(pobi, kirby, jonge)));

        assertThat(winners.winners()).containsExactly(kirby, jonge);
    }
}