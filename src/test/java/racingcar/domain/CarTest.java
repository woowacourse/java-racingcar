package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    @DisplayName("자동차 이동시 랜덤값이 4이상인 경우 position변화 테스트")
    public void drive_forward_value(int value) {
        Car car = Car.fromName(Name.from("is2js"));
        car.drive(value);

        assertThat(1).isEqualTo(car.getPosition().getPositionValue());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    @DisplayName("자동차 이동시 랜덤값이 3이하인 경우 position변화 테스트")
    public void drive_stop_value(int value) {
        Car car = Car.fromName(Name.from("is2js"));
        car.drive(value);

        assertThat(0).isEqualTo(car.getPosition().getPositionValue());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 유효한 길이인지 검사")
    @ValueSource(strings = {"5자이하", "is2js", "코니"})
    void valid_carName_length(String name) {
        assertDoesNotThrow(() -> Car.fromName(Name.from(name)));
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 유효하지 않은 길이인지 검사")
    @ValueSource(strings = {"5자초과닉넴", "is2js3js", "코니포코포비"})
    void invalid_carName_length(String name) {
        assertThatThrownBy(() -> Car.fromName(Name.from(name))).isInstanceOf(IllegalArgumentException.class);
    }
}
