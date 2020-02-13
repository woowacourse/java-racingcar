package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domian.RacingCar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    private static RacingCar game;

    @BeforeAll
    static void setUp() {
        game = new RacingCar();
    }

    @ParameterizedTest
    @ValueSource(strings = {"11"})
    @DisplayName("경주 Round 카운트가 10초과 혹은 1보다 작은 경우")
    void 횟수가_10초과_및_1보다작은_경우(String count) {
        InputStream in = new ByteArrayInputStream(count.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> {
            game.setUpRound();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("횟수가 1보다 작거나 10번 초과");
    }


    @Test
    @DisplayName("경주 Round 카운트가 숫자가 아닌 경우")
    void 횟수가_숫자가_아닌_경우() {
        String count = "a";
        InputStream in = new ByteArrayInputStream(count.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            game.setUpRound();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 횟수 입력");
    }
}
