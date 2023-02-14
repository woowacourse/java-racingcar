package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.DrivableNumberGenerator;
import utils.NonDrivableNumberGenerator;
import utils.RandomNumberGenerator;

class CarTest {

    @Test
    void 차량_전진_테스트() {
        //given
        final int DRIVING_DISTANCE = 1;
        Car car = new Car("test", new DrivableNumberGenerator());
        //when
        car.drive();
        //then
        assertThat(car.getDrivenDistance()).isEqualTo(DRIVING_DISTANCE);
    }

    @Test
    void 차량_정지_테스트() {
        //given
        Car car = new Car("test", new NonDrivableNumberGenerator());
        //when
        car.drive();
        //then
        assertThat(car.getDrivenDistance()).isEqualTo(0);
    }

    @Test
    void 차량_이름이_1자_이하일시_오류를_던진다() {
        assertThatThrownBy(() -> {
            new Car("", new RandomNumberGenerator());
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] ")
            .hasMessageContaining("자동차 이름 길이는 1자 이상, 5자 이하여야합니다.");
    }

    @Test
    void 차량_이름이_5자_초과일시_오류를_던진다() {
        assertThatThrownBy(() -> {
            new Car("123456", new RandomNumberGenerator());
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] ")
            .hasMessageContaining("자동차 이름 길이는 1자 이상, 5자 이하여야합니다.");
    }

    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    @ParameterizedTest
    void 차량_이름은_1자이상_5자이하여야한다(String carName) {
        // when
        Car car = new Car(carName, new RandomNumberGenerator());
        // then
        assertThat(car.getName()).isEqualTo(carName);
    }
}
