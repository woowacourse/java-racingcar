package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}