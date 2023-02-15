package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", ""})
    @NullSource
    @DisplayName("Car() : 차 이름이 1글자 미만 및 빈칸일 경우 IllegalArgumentException 발생")
    void test_carConstructor_IllegalArgumentException(String name) throws Exception {
        //given
        String expectedMessage = "자동차 이름은 빈칸일 수 없습니다.";

        //when & then
        assertThatThrownBy(() -> {
            new Car(Name.fromName(name));
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("Car() : 차 이름이 5글자 초과일 경우 IllegalArgumentException 발생")
    void test_carConstructor_IllegalArgumentException() {
        //given
        String name = "abcdef";
        String expectedMessage = "자동차 이름은 1글자 이상 5글자 이하로 작성해주세요.";

        //when & then
        assertThatThrownBy(() -> {
            new Car(Name.fromName(name));
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessage(expectedMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde"})
    @DisplayName("Car() : 차 이름이 빈칸이 아니고, 1글자 이상 5글자 이하일 경우 제대로 생성된다.")
    void test_carConstructor_success(String name) throws Exception {
        //when & then
        new Car(Name.fromName(name));
    }
}
