package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarDto;
import racingcar.util.DeterminedIntGenerator;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @DisplayName("이동 시도 시, 정수 값에 따라 이동 횟수가 달라진다.")
    @CsvSource(value = {"1:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    void shouldPlusOneAtMovedCountWhenMove(int number, int addedMovedCount) {
        // given
        Car targetCar = new Car("test", new DeterminedIntGenerator(number));
        CarDto carDtoBeforeMove = new CarDto(targetCar);
        // when
        targetCar.tryMove();
        CarDto carDtoAfterMove = new CarDto(targetCar);
        // then
        assertThat(carDtoAfterMove.getName()).isEqualTo(carDtoBeforeMove.getName());
        assertThat(carDtoAfterMove.getMovedCount()).isEqualTo(carDtoBeforeMove.getMovedCount() + addedMovedCount);
    }

    @Test
    @DisplayName("적절한 길이의 이름으로 Car를 생성한다.")
    void shouldCreateCarCorrectlyWhenUseAppropriateName() {
        // given
        String appropriateName = "테스트이름";
        // when
        Car car = new Car(appropriateName);
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
                    new Car(wrongName);
                });
    }
}