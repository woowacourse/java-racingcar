package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.utils.numbergenerator.MovableNumberGenerator;

class WinnersTest {

    @Test
    void 우승자_rick() {
        Cars cars = new Cars(Arrays.asList(
                new Car("rick", new MovableNumberGenerator(), 3),
                new Car("huni", new MovableNumberGenerator(), 0)));

        Winners winners = new Winners(cars);

        assertThat(winners.getWinners())
                .containsExactly("rick");
    }

    @Test
    void 공동_우승자_rick_huni() {
        Cars cars = new Cars(Arrays.asList(
                new Car("rick", new MovableNumberGenerator(), 4),
                new Car("huni", new MovableNumberGenerator(), 4)));

        Winners winners = new Winners(cars);

        assertThat(winners.getWinners())
                .containsExactly("rick", "huni");
    }

}