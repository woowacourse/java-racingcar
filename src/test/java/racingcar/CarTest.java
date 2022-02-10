package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("이름으로 자동차 생성 테스트")
    void carTest() {
        // given
        String testName = "testCar";

        // when
        Car car = new Car(testName);

        // then
        assertThat(car.getName()).isEqualTo(testName);
    }

}
