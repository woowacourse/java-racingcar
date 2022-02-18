package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    RacingGame racingGame = new RacingGame();

    @Test
    void 최종_우승자_출력() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("bom", 3));
        carList.add(new Car("sun", 4));
        Cars cars = new Cars(carList);

        String winnerName = racingGame.findWinner();
        assertThat(winnerName).contains("sun").doesNotContain("bom");
    }
}