package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGoForwardOrStopUtilsTest {

    @DisplayName("생성된 랜덤 숫자가 4 이상인 경우, 자동차는 한 칸 앞으로 전진해야 한다.")
    @Test
    void carGoForward() {
        int generatedRandomNumber = 4;
        Car car = new Car("111");
        int positionBeforeGoForward = car.getPosition();
        CarGoForwardOrStopUtils.goForwardIfRandomNumberIsFourOrMore(car, generatedRandomNumber);
        assertThat(car.getPosition()).isEqualTo(positionBeforeGoForward + 1);
    }

    @DisplayName("생성된 랜덤 숫자가 3 이하인 경우, 자동차는 한 칸 앞으로 전진해야 한다.")
    @Test
    void carStop() {
        int generatedRandomNumber = 3;
        Car car = new Car("111");
        int positionBeforeStop = car.getPosition();
        CarGoForwardOrStopUtils.goForwardIfRandomNumberIsFourOrMore(car, generatedRandomNumber);
        assertThat(car.getPosition()).isEqualTo(positionBeforeStop);
    }
}
