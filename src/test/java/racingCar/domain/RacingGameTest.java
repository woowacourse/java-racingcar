package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    public void prepare_Cars_테스트() {
        //given, when
        String[] carNames = {"pobi"};

        //then
        assertThat(RacingGame.prepareCars(carNames)
            .stream()
            .findFirst()
            .get()
            .getName())
            .isEqualTo("pobi");
    }
}