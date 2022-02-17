package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racingcar.model.car.Name;

public class InputFormatorTest {
    @Nested
    @DisplayName("toNameList 메소드는")
    class ToNameList {
        @Nested
        @DisplayName(",로 구분된 문자열이 주어지면")
        class Context_with_string_contain_comma {
            @Test
            @DisplayName(",로 구분하여 이름 리스트를 반환한다.")
            void it_returns_name_list() {
                String input = "name1,name2,name3";
                assertThat(InputFormator.toNameList(input)).contains(
                    new Name("name1"), new Name("name2")
                );
            }
        }

        @Nested
        @DisplayName(",,,, 같이 ,로 이루어진 문자열이 주어지면")
        class Context_with_string_only_comma {
            @Test
            @DisplayName("예외를 발생시킨다.")
            void it_throw_exception() {
                String input = ",,,,";
                assertThatThrownBy(() -> InputFormator.toNameList(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("올바르지 않은 입력값입니다.");
            }
        }

        @Nested
        @DisplayName(",로 구분된 문자열이 중복되는 값이 주어지면")
        class Context_with_duplicate_string_when_split_comma {
            @Test
            @DisplayName("예외를 발생시킨다.")
            void it_throw_exception() {
                String input = "a,a,aa";
                assertThatThrownBy(() -> InputFormator.toNameList(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 이름을 가지고 있습니다.");
            }
        }

    }
}
