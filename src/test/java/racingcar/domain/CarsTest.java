package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("중복 이름이 있을 때 예외가 발생한다")
    void duplicateTest() {
        Car car1 = new Car("aa");
        Car car2 = new Car("aa");

        assertThatThrownBy(() -> new Cars(List.of(car1, car2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }
    @Test
    @DisplayName("경기에 참여하는 차가 한대일때 예외가 발생한다")
    void oneCarTest() {
        Car car1 = new Car("aa");

        assertThatThrownBy(() -> new Cars(List.of(car1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("둘 이상");
    }

}