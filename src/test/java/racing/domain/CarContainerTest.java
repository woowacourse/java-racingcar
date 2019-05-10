package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarContainerTest {
    @Test
    void addCars() {
    }

    @Test
    void 우승자찾기1() {
        CarContainer carContainer = new CarContainer();
        String[] names = {"pobi", "jason", "buddy", "luffy"};
        int[] positions = {1, 5, 9, 9};
        carContainer.addCars(names, positions);
        assertThat(carContainer.searchWinners()).isEqualTo(Arrays.asList("buddy", "luffy"));
    }

    @Test
    void 토탈타임예외확인() {
        CarContainer carContainer = new CarContainer();
        assertThrows(IllegalArgumentException.class, () -> {
            carContainer.setTotalTimes(0);
        });
    }

    @Test
    void 토탈타임예외확인2() {
        CarContainer carContainer = new CarContainer();
        assertThrows(IllegalArgumentException.class, () -> {
            carContainer.setTotalTimes(-2);
        });
    }
}