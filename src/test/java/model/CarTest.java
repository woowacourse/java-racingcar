package model;

import message.Exception;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
        car.forward();
        car.stop();
        car.forward();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 없을 시 예외가 발생한다.")
    void validateNullAndEmpty(String input) {
        assertThatThrownBy(() -> new Car(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 6자 이상일 시 예외가 발생한다.")
    void validateNameLength() {
        String name = "abcdefg";
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차들이 중복된 이름을 가질 시 예외가 발생한다.")
    void validateDuplicate() {
        assertThatThrownBy(() -> Car.convertToCar(List.of("aaa","aaa")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("경주 현황을 알 수 있다.")
    void getStatues() {
        assertThat(car.getStatuses())
                .containsExactly(MoveStatus.FORWARD, MoveStatus.STOP, MoveStatus.FORWARD);
    }

    @Test
    @DisplayName("전진한 횟수를 알 수 있다.")
    void getForwardCount() {
        assertThat(car.getForwardCount()).isEqualTo(2);
    }
}
