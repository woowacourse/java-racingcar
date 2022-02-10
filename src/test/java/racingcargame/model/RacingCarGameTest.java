package racingcargame.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class RacingCarGameTest {

    @Test
    void 입력받은_자동차_개수_테스트() {
        assertThat(CarRepository.getSize()).isEqualsTo(3);
    }
}