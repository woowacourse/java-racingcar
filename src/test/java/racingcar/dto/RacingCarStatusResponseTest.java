package racingcar.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class RacingCarStatusResponseTest {

    @Test
    @DisplayName("asString 호출 시 명세한 문자열이 반환되어야 한다.")
    void asString_success() {
        // given
        Car car = new Car("Glen", 5);
        RacingCarStatusResponse response = RacingCarStatusResponse.of(car);

        // expect
        assertThat(response.asString())
                .isEqualTo("Glen : -----");
    }
}
