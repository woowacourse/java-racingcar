package com.woowacourse.javaracingcar.domain;

import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RacingcarGameTest {

    @Test
    void testNormalCase() {
        int[] numsToGenerate = {1, 2, 5, 3, 5, 7, 6, 4, 3};
        RacingcarGame game = new RacingcarGame(new TestNumberGenerator(numsToGenerate),
            Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux")));

        assertThat(game.loop()).isEqualTo(Arrays.asList(
            new CarDto("pobi", 0),
            new CarDto("crong", 0),
            new CarDto("honux", 1)
        ));
        assertThat(game.loop()).isEqualTo(Arrays.asList(
            new CarDto("pobi", 0),
            new CarDto("crong", 1),
            new CarDto("honux", 2)
        ));
        assertThat(game.loop()).isEqualTo(Arrays.asList(
            new CarDto("pobi", 1),
            new CarDto("crong", 2),
            new CarDto("honux", 2)
        ));
        assertThat(game.getWinners()).isEqualTo(Arrays.asList(
            new CarDto("crong", 2),
            new CarDto("honux", 2)
        ));
    }

    @Test
    void testEmptyCarList() {
        int[] numsToGenerate = {1, 2, 5};
        NumberGenerator numberGenerator = new TestNumberGenerator(numsToGenerate);

        assertThrows(IllegalArgumentException.class, () -> {
            new RacingcarGame(numberGenerator, Collections.emptyList());
        });
    }
}