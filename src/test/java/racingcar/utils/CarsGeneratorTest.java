package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarsGeneratorTest {

    @Test
    @DisplayName("올바른 자동차 생성 검증")
    void generateTest() {
        assertThat(CarsGenerator.generateCars("pobi,crong,honux"))
                .contains(new Car("pobi"), new Car("crong"), new Car("honux"));
    }

    @Test
    @DisplayName("부적절한 이름으로 자동차를 생성하려는 경우 예외 발생 - 자동차 이름 글자수 초과")
    void invalidCarName_length() {
        assertThatThrownBy(
                () -> CarsGenerator.generateCars("pobi,crdong,honux")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("부적절한 이름으로 자동차를 생성하려는 경우 예외 발생 - whitespace")
    void invalidCarName_whitespace() {
        assertThatThrownBy(
                () -> CarsGenerator.generateCars(" ,   , ")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("부적절한 이름으로 자동차를 생성하려는 경우 예외 발생 - emptyString")
    void invalidCarName_emptyString() {
        assertThatThrownBy(
                () -> CarsGenerator.generateCars(",,,,")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}