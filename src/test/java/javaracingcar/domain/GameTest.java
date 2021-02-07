package javaracingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @DisplayName("게임 실행 실패 : 중복된 자동차 이름 전달")
    void init_DuplicatedCarNames_ExceptionThrown() {
        List<String> carNames = Arrays.asList("a","b","c","a");
        assertThatThrownBy(() -> Game.init(carNames, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름");
    }

    @Test
    @DisplayName("게임 실행 성공 : 중복 없는 자동차 이름 전달")
    void init_NonDuplicatedCarNames_GameSuccessfullyGenerated() {
        List<String> carNames = Arrays.asList("a", "b", "c", "d");
        int trial = 5;
        Game game = Game.init(carNames, trial);
        assertEquals(game.getCarNames(), carNames);
        assertEquals(game.getTrial(), trial);
    }
}