package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "가나다라마바"})
    @DisplayName("차 이름 길이가 범위 밖인 경우 예외가 발생한다")
    void createCarWithNameOutOfRange(String name) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가", "가나다라마"})
    @DisplayName("차 이름 길이가 범위 내인 경우 통과한다")
    void createCarWithCorrectNameRange(String name) {
        //given
        //when
        new Car(name);
        //then
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2", "9:2", "0:1", "3:1"}, delimiter = ':')
    @DisplayName("차가 가지는 힘에 따른 이동, 정차를 테스트한다")
    void checkCarPositionByPower(int power, int position) {
        //given
        Car car1 = new Car("car1");

        //when
        car1.move(power);

        //then
        assertThat(car1.getCurrentPosition()).isEqualTo(position);
    }
}