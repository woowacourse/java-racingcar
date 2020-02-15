package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Car.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private Car pobi;

    @BeforeEach
    void setUp() {
        pobi = new Car("pobi");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "kyle", "hodol"})
    @DisplayName("정상적으로 생성되는 경우")
    void constructorWithoutException(String value) {
        assertThat(new Car(value));
    }

    @Test
    @DisplayName("Null인자의 경우 예외발생")
    void constructorNull() {
        assertThatThrownBy(() -> {
            new Car(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("길이초과의 경우 예외발생")
    void constructorOverLength() {
        assertThatThrownBy(() -> {
            new Car("moreThanFiveLetters");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", "", "        "})
    @DisplayName("빈 문자열의 경우 예외발생")
    void constructorEmpty(String value) {
        assertThatThrownBy(() -> {
            new Car(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("포지션 동점자의 이름을 반환")
    void getCoWinnersNameTest() {
        Car other = new Car("young");
        other.move(CRITERIA);
        pobi.move(CRITERIA);
        assertThat(pobi.nameIfOn(1)).isEqualTo("pobi");
    }
}
