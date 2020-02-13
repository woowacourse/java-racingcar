package racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcargame.domain.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @ParameterizedTest
    @DisplayName("이름이 올바른지 확인")
    @ValueSource(strings = {"abcdef", ""})
    void lengthTest(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상 5자 이하로 해주세요.");
    }

    @Test
    @DisplayName("이름을 입력하지 않은 경우")
    void nullTest() {
        assertThatThrownBy(() -> {
            String nullString = null;
            Car car = new Car(nullString);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 null값이 될 수 없습니다.");
    }

    @Test
    @DisplayName("이름에 띄어쓰기가 포함된 경우")
    void blankTest() {
        assertThatThrownBy(() -> {
            Car car = new Car("ab c");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에는 띄어쓰기가 포함될 수 없습니다.");
    }
}
