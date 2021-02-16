package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @Test
    @DisplayName("distance 생성 확인 테스트")
    public void distance_생성() {
        Distance distance = new Distance(0);

        assertThat(distance).isEqualTo(new Distance(0));
    }
}