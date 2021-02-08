package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.Car.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @DisplayName("정상적인 이름이 들어왔을 떄 Car가 잘 생성되는지")
    @Test
    void carConstructor_properName_createCar() {
        String name = "포비";
        Car car = new Car(name);

        assertThat(car).isInstanceOf(Car.class);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(INIT_POSITION);
    }

    @DisplayName("적합한 이름과 포지션이 둘다 주어졌을떄 Car가 잘 생성되는지")
    @Test
    void carConstructor_properNameAndPosition_createCar() {
        String name = "데이브";
        int position = 4;
        Car car = new Car(name, position);

        assertThat(car).isInstanceOf(Car.class);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("이름에 공백이 있을 때 에러를 반환 하는지")
    @Test
    void validateBlankInName_NameContainsBlank_throwIllegalArgumentException() {
        assertThatThrownBy(() -> new Car("포비 ")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_ERROR_MESSAGE);
    }

    @DisplayName("이름이 1자 미만 5자 초과일때 에러를 반환 하는지")
    @ParameterizedTest
    @ValueSource(strings = {"포비넌너무멋져남자가봐도반하겠어", ""})
    void validateNameLength_NameLengthOutOfBounds_throwIllegalArgumentException(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("주어진 숫자에 따라 자동차가 움직이는지 테스트")
    @ParameterizedTest
    @CsvSource({"2, false", "3,false", "4,true", "5,true"})
    void move_givenNumberToMoveCars_moveAccordingToNumber(int given, boolean result) {
        Car car = new Car("TEST");
        car.move(given);

        assertThat(car.getPosition() == 1).isEqualTo(result);
    }
}