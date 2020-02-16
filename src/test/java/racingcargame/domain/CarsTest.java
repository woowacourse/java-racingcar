package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarsTest {
    @Test
    void cars생성_확인() {
        String[] carNames = "라테, 제이, 포비".split(",");
        Cars cars = new Cars(Names.valueOf(carNames));
        assertThat(cars.getCars())
                .extracting("name")
                .extracting("name")
                .contains("라테").contains("제이").contains("포비");
    }

    @Test
    void null방어로직_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Cars(null));
    }

    @Test
    void 현재Cars중_maxPosition에_있는_CarName을_반환() {
        String[] carNames = "라테, 제이, 포비".split(",");
        Cars cars = new Cars(Names.valueOf(carNames));
        cars.getCars().get(0).move(4);
        assertThat(cars.findWinnerNames())
                .extracting("name")
                .contains("라테")
                .doesNotContain("제이")
                .doesNotContain("포비");
    }

    @Test
    void 현재Cars를_전진() {
        String[] carNames = "라테, 제이, 포비".split(",");
        Cars cars = new Cars(Names.valueOf(carNames));
        cars.moveOneRound();
    }
}
