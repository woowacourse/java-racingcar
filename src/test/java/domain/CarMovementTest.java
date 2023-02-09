package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarMovement;

import static org.assertj.core.api.Assertions.*;

public class CarMovementTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("정상 자동차 움직임 생성자 테스트")
    public void validCarMovementTest(int value) {
        CarMovement carMovement = new CarMovement(value);
        assertThat(carMovement).extracting("value").isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, 30, 40, 50})
    @DisplayName("비정상 자동차 움직임 생성자 테스트")
    public void invalidCarMovementTest(int value) {
        assertThatThrownBy(() -> {
            new CarMovement(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "3:false", "4:true"},delimiter = ':')
    @DisplayName("자동차 움직임 작동 테스트")
    public void isMoveTest(int value, boolean expected) {
        CarMovement carMovement = new CarMovement(value);
        assertThat(carMovement.isMove()).isEqualTo(expected);
    }

}
