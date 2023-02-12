package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class CarTest {

    private final RacingRule rule = new StandardRacingRule();

    @ParameterizedTest(name = "자동차 이름 검증 테스트 - 입력이름 : \"{0}\"")
    @ValueSource(strings = {"abcdef", "", "  "})
    void carNameExceptionTest(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 위치 확인 테스성")
    void getPositionTest() {
        Car car = new Car("test");
        car.moveWith(0, rule);
        car.moveWith(5, rule);
        car.moveWith(6, rule);

        int expectedPosition = 2;
        int expectedTurnCount = 3;

        assertSoftly(softly -> {
            softly.assertThat(car.getPosition()).isEqualTo(expectedPosition);
            softly.assertThat(car.getTurnCount()).isEqualTo(expectedTurnCount);
        });
    }
}
