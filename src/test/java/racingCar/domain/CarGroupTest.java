package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarGroupTest {

    @Test
    @DisplayName("자동차 이름들에 중복이 있는 경우")
    void carGroupTest_fail() {
        List<String> carNames = List.of("abc", "abc");

        Assertions.assertThatThrownBy(()->{
            new CarGroup(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}