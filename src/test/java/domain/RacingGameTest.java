package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void racingGameGenerateTest() {
        //Given
        int round = 0;

        //When
        Throwable result = catchThrowable(()-> {new RacingGame(round);});

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}