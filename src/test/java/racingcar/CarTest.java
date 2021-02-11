package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Name;

public class CarTest {

    @Test
    @DisplayName("정상적인 자동차 이름 입력")
    void generateCarTest_정상_입력() {
        assertThatCode(() -> {
            new Car(new Name("루트"));
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("기능 요구사항보다 너무 길거나 짧은 자동차 이름 입력")
    @ValueSource(strings = {"너무 긴 이름", ""})
    void generateCarTest_잘못된_길이_입력(String name) {
        assertThatThrownBy(() -> {
            new Car(new Name(name));
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자 이하로 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("매직 넘버에대한 자동차 이동")
    @CsvSource(value = {"5, 1", "3, 0", "4, 1", "100, 1"}, delimiter = ',')
    void tryToMoveTest(int input, int expected) {
        final Car car = new Car(new Name("테스트"));
        car.tryToMove(input);
        final int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }
}
