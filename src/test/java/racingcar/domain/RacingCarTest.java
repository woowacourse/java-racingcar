package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import racingcar.domian.RacingCar;

public class RacingCarTest {
    RacingCar game;

    @BeforeAll
    void setUp() {
        game = new RacingCar();
    }

/*    @ParameterizedTest
    @ValueSource(ints = {-1, 11, 0})
    void 횟수가_10초과_및_1보다작은_경우(int count) {
        assertThatThrownBy(() -> {
            validateCount(count);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("횟수가 1보다 작거나 10번 초과");
    }

    @Test
    void 횟수가_숫자가_아닌_경우() {
        String count = "a";
        assertThatThrownBy(() -> {
            validateNumber(count);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 횟수 입력");
    }

    @Test
    void 자동자가_5대_초과로_오는_경우() {
        int carCount = 6;
        assertThatThrownBy(() -> {
            validateCarCount(carCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 5대 초과");
    }*/
}
