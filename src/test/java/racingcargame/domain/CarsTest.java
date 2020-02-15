package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void cars생성_확인() {
        String[] carNames = "라테, 제이, 포비".split(",");
        Cars cars = new Cars(Names.valueOf(carNames));
        assertThat(cars).isNotNull();
        assertThat(cars.getCars()).
                extracting("name").
                extracting("name").
                contains("라테");
    }

    @Test
    void 현재Cars중_maxPosition에_있는_CarName을_반환() {
        String[] carNames = "라테, 제이, 포비".split(",");
        Cars cars = new Cars(Names.valueOf(carNames));
        cars.getCars().get(0).move(4);
        assertThat(cars.findWinnerNames().getNames())
                .extracting("name")
                .contains("라테");
        assertThat(cars.findWinnerNames().getNames())
                .extracting("name")
                .doesNotContain("제이");
        assertThat(cars.findWinnerNames().getNames())
                .extracting("name")
                .doesNotContain("포비");
    }

    @Test
    void 현재Cars를_전진() {
        String[] carNames = "라테, 제이, 포비".split(",");
        Cars cars = new Cars(Names.valueOf(carNames));
        cars.moveOneRound();
    }
}
