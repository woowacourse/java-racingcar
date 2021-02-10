package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingCar.domain.Engine.RandomEngine;

class RacingGameTest {

    @Test
    public void prepare_Cars_테스트 (){
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