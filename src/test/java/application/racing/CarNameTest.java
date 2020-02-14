package application.racing;

import application.racing.domain.CarName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {
    @DisplayName("비정상적인 입력에 대해 예외를 던지는지 CarName 클래스 생성자 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "ab cd", "abcdefg"})
    public void carNameConstructorTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            new CarName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("equals 메소드 오버라이드 테스트")
    @Test
    public void CarNameEqualsTest() {
        CarName input = new CarName("lavin");

        CarName expected = new CarName("lavin");

        Assertions.assertThat(input).isEqualTo(expected);
    }
}
