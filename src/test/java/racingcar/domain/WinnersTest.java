package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.domain.movestrategy.MovableMovingStrategy;

class WinnersTest {

    @Test
    void 우승자_rick() {
        Cars cars = new Cars(Arrays.asList(
                new Car("rick", new MovableMovingStrategy(), 3),
                new Car("huni", new MovableMovingStrategy(), 0)));

        Winners winners = new Winners(cars);

        assertThat(winners.getWinners())
                .containsExactly("rick");
    }

    @Test
    void 공동_우승자_rick_huni() {
        Cars cars = new Cars(Arrays.asList(
                new Car("rick", new MovableMovingStrategy(), 4),
                new Car("huni", new MovableMovingStrategy(), 4)));

        Winners winners = new Winners(cars);

        assertThat(winners.getWinners())
                .containsExactly("rick", "huni");
    }

}