package racingcargame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void cars생성_확인() {
        List<String> carNames = Arrays.asList("라테, 제이, 포비".split(","));
        Cars cars = new Cars(carNames);
        assertThat(cars).isNotNull();
        assertThat(cars.getCars()).
                extracting("name").
                extracting("name").
                contains("라테");
    }

    @Test
    void 현재Cars중_maxPosition에_있는_CarName을_반환() {
        List<String> carNames = Arrays.asList("라테, 제이, 포비".split(","));
        Cars cars = new Cars(carNames);
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
        List<String> carNames = Arrays.asList("라테, 제이, 포비".split(","));
        Cars cars = new Cars(carNames);
        cars.moveOneRound();
    }
}
