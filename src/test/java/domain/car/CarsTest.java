package domain.car;

import domain.racing.RacingRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("유효한 문자열 리스트가 입력되면 Cars 객체를 생성한다.")
    @Test
    void generateCars() throws Exception {
        // Given
        List<String> carNames = List.of("car1", "car2", "car3");
        RacingRule racingRule = new RacingRule();

        // When
        Cars cars = Cars.of(carNames, racingRule);

        // Then
        assertThat(cars).isNotNull();
    }

    @DisplayName("2미만 크기의 문자열 리스트가 입력되면 예외가 발생한다.")
    @Test
    void initCarsThrowExceptionWhenListSizeLessThanOne() throws Exception {
        // Given
        List<String> invalidInput = List.of("test");
        RacingRule racingRule = new RacingRule();

        // When & Then
        assertThatThrownBy(() -> Cars.of(invalidInput, racingRule))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 개수는 2이상이여야 합니다.");
    }

    @DisplayName("중복된 이름이 있는 문자열 리스트가 입력되면 예외가 발생한다.")
    @Test
    void initCarsThrowExceptionWhenDuplicatedCarNames() throws Exception {
        // Given
        List<String> invalidInput = List.of("test", "test");
        RacingRule racingRule = new RacingRule();

        // When & Then
        assertThatThrownBy(() -> Cars.of(invalidInput, racingRule))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름을 허용하지 않습니다.");
    }
}
