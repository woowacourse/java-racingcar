package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @Test
    void 생성자_중복이름() {
        assertThatThrownBy(() -> new Cars(Arrays.asList("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 단독_우승자() {
        Cars cars = new Cars(Arrays.asList("pobi", "crong", "honux"));
        cars.getCars().get(0).forward(true);
        assertThat(cars.getWinnerNames()).containsExactly("pobi");
    }

    @Test
    void 공동_우승자() {
        Cars cars = new Cars(Arrays.asList("pobi", "crong", "honux"));
        cars.getCars().get(0).forward(true);
        cars.getCars().get(1).forward(true);
        assertThat(cars.getWinnerNames()).containsExactly("pobi", "crong");
    }
}