/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        11 Feb 2020
 *
 */

package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @DisplayName("입력에 공백이 있을 때 오류를 내보내는지 테스트")
    @Test
    void validateHasBlank() {
        assertThatThrownBy(() -> new Car("가나다 ", 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("공백");
    }

    @DisplayName("입력이 6자 이상일 때 오류를 내보내는지 테스트")
    @Test
    void validateNameLength() {
        assertThatThrownBy(() -> new Car("가나다라마바", 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("6자");
    }

    @DisplayName("생성자가 정상적으로 동작하는지 테스트")
    @Test
    void carName() {
        Car car = new Car("가나다", 0);
        assertThat(car.getName()).isEqualTo("가나다");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("랜덤넘버가 4이상일 때 전진하는지 보는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void movePosition(int randomNo, int expected) {
        Car car = new Car("가나다", 0);
        car.move(randomNo);
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("랜덤넘버가 4이하일 때 정지하는지 보는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0"}, delimiter = ':')
    void stopPosition(int randomNo, int expected) {
        Car car = new Car("가나다", 0);
        car.move(randomNo);
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("차가 전진하면 스트링으로 출력이 되는지 확인하는 테스트")
    @Test
    void toStringCar() {
        Car car = new Car("가나다", 0);
        car.move(4);
        car.move(4);
        car.move(4);
        assertThat(car.toString()).isEqualTo("가나다 : ---\n");
    }
}
