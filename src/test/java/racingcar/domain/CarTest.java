package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.DeterminedIntGenerator;
import racingcar.util.RacingCarIntGenerator;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @DisplayName("이동 시도 시, 정수 값에 따라 이동 횟수가 달라진다.")
    @CsvSource(value = {"1:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    void shouldPlusOneAtMovedCountWhenMove(int number, int movedCount) {
        // given
        Car targetCar = new Car("test", new DeterminedIntGenerator(number));
        // when
        targetCar.tryMove();
        // then
        assertThat(targetCar.getMovedCount()).isEqualTo(movedCount);
    }

    @Test
    @DisplayName("적절한 길이의 이름으로 Car를 생성한다.")
    void shouldCreateCarCorrectlyWhenUseAppropriateName() {
        // given
        String appropriateName = "테스트이름";
        // when
        Car car = new Car(appropriateName, new RacingCarIntGenerator());
        // then
        assertThat(car.getName()).isEqualTo(appropriateName);
    }

    @ParameterizedTest
    @DisplayName("잘못된 길이의 이름으로 Car를 생성하면 예외가 발생한다.")
    @ValueSource(strings = {"가나다라마바", " "})
    void shouldThrowIllegalArgumentExceptionWhenUseLongName(String inputName) {
        // given
        String wrongName = inputName;
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> { // when
                    new Car(wrongName, new RacingCarIntGenerator());
                });
    }
}