package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domain.car.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("Car 객체를 생성하는 기능")
    @Test
    void testInitCar() {
        //given
        String name = "benz";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("Car의 이름이 Car의 이름제한길이보다 크면 예외를 발생시킨다.")
    @Test
    void testInitCarIfCarNameLengthLongerThanCarNameLengthLimit() {
        //given
        String name = "123456";

        //when //then
        assertThatThrownBy(() -> new Car(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Car의 이름이 null이나 공백이 입력되면 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    void testInitCarIfCarNameIsNullOrEmpty(String carName) {
        //when // then
        assertThatThrownBy(() -> new Car(carName))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Car의 이름에 특수문자가 포함된 경우 예외를 발생시킨다.")
    @Test
    void testInitCarIfCarNameContainsSpecialCharacter() {
        //given
        String name = "be+nz";

        //when //then
        assertThatThrownBy(() -> new Car(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}