package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class CarTest {

    @ParameterizedTest(name = "자동차 이름 검증 테스트 - 입력이름 : \"{0}\"")
    @ValueSource(strings = {"abcdef", "", "  "})
    void carNameExceptionTest(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이동 조건 value 기록 추가에 대한 테스트")
    void addValueTest() {
        Car car = new Car("test");
        car.addValue(4);
        int firstSize = car.getLogSize();
        car.addValue(5);
        int secondSize = car.getLogSize();
        assertSoftly(softly -> {
            softly.assertThat(firstSize).isEqualTo(1);
            softly.assertThat(secondSize).isEqualTo(2);
        });
    }

    @Test
    @DisplayName("자동차 위치 확인 테스성")
    void getPositionTest() {
        Car car = new Car("test");
        car.addValue(0);
        car.addValue(4);
        car.addValue(9);

        assertThat(car.getPosition(Rule.MOVING_FORWARD_STANDARD.getStep(), Rule.MOVING_FORWARD_STANDARD.getThreshold())).isEqualTo(2);

    }
}
