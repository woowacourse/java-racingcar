package domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarFactoryTest {

    @DisplayName("유효한 문자열 리스트가 입력되면 Cars 객체를 반환한다.")
    @Test
    void generateCars() throws Exception {
        // Given
        List<String> carNames = List.of("car1", "car2", "car3");

        // When
        Cars cars = CarFactory.generateCars(carNames);

        // Then
        assertThat(cars).isNotNull();
    }

    @DisplayName("2미만 크기의 문자열 리스트가 입력되면 예외가 발생한다.")
    @Test
    void initCarsThrowExceptionWhenListSizeLessThanOne() throws Exception {
        // Given
        List<String> invalidInput = List.of("test");

        // When & Then
        assertThatThrownBy(() -> CarFactory.generateCars(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 개수는 2이상이여야 합니다.");
    }

    @DisplayName("중복된 이름이 있는 문자열 리스트가 입력되면 예외가 발생한다.")
    @Test
    void initCarsThrowExceptionWhenDuplicatedCarNames() throws Exception {
        // Given
        List<String> invalidInput = List.of("test", "test");

        // When & Then
        assertThatThrownBy(() -> CarFactory.generateCars(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름을 허용하지 않습니다.");
    }
}
