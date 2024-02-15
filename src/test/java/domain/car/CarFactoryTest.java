package domain.car;

import domain.car.CarFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarFactoryTest {

    @DisplayName("1 이하 크기의 문자열 리스트가 입력되면 예외가 발생한다.")
    @Test
    void initCarsThrowExceptionWhenListSizeLessThanOne() throws Exception {
        // Given
        List<String> invalidInput = List.of("test");

        // When & Then
        Assertions.assertThatThrownBy(() -> CarFactory.generateCars(invalidInput))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("자동차 이름의 개수는 2이상이여야 합니다.");
    }
    
    @DisplayName("중복된 이름이 있는 문자열 리스트가 입력되면 예외가 발생한다.")
    @Test
    void initCarsThrowExceptionWhenDuplicatedCarNames() throws Exception {
        // Given
        List<String> invalidInput = List.of("test", "test");

        // When & Then
        Assertions.assertThatThrownBy(() -> CarFactory.generateCars(invalidInput))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("중복된 자동차 이름을 허용하지 않습니다.");
    }
}
