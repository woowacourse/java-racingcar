package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarDto;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("1회 이동")
    void shouldPlusOneAtMovedCountWhenMove() {
        // given
        Car targetCar = new Car("test");
        CarDto carDtoBeforeMove = targetCar.getStatus();
        // when
        targetCar.move();
        CarDto carDtoAfterMove = targetCar.getStatus();
        // then
        assertThat(carDtoAfterMove.getName()).isEqualTo(carDtoBeforeMove.getName()).as("이름이 같아야 한다.");
        assertThat(carDtoAfterMove.getMovedCount()).isEqualTo(carDtoBeforeMove.getMovedCount() + 1).as("이동 횟수는 1이 더해진다.");
    }

    @Test
    @DisplayName("올바른 이름으로 생성")
    void shouldCreateCarCorrectlyWhenUseAppropriateName() {
        // given
        String appropriateName = "테스트이름";
        // when
        Car car = new Car(appropriateName);
        // then
        assertThat(car.getStatus().getName()).isEqualTo(appropriateName);
    }

    @ParameterizedTest
    @DisplayName("예외 발생 - 잘못된 이름 길이")
    @ValueSource(strings = {"아주 긴 이름입니다", " "})
    void shouldThrowIllegalArgumentExceptionWhenUseLongName(String inputName) {
        // given
        String wrongName = inputName;
        // when
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(wrongName);
                });}
}