package service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    void 이름들로_자동차들_생성_테스트() {
        RacingGame racingGame = new RacingGame();
        List<String> carNames = Arrays.asList("aaa", "bbb", "ccc");
        racingGame.generateCars(carNames);

        assertThat(racingGame.getCars().size()).isEqualTo(carNames.size());
    }
}