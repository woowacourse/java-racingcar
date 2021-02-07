package javaracingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputControllerTest {

    @Nested
    @DisplayName("자동차 이름 입력 테스트")
    class getCarNames {
        @Test
        @DisplayName("자동차 이름 입력 실패 : Null 입력")
        void getCarNames_Null_ExceptionThrown() {
            assertThatThrownBy(() -> InputController.getCarNames(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("null");
        }

        @Test
        @DisplayName("자동차 이름 입력 성공 : Null이 아닌 문자열 입력")
        void getCarNames_NotNull_ExceptionThrown() {
            String input = ",,A,B,C";
            List<String> names = Arrays.asList("", "", "A", "B", "C");
            assertEquals(InputController.getCarNames(input)
                    .size(), names.size());
            assertEquals(names, InputController.getCarNames(input));
        }
    }

    @Nested
    @DisplayName("시도 횟수 입력 테스트")
    class getTrial {
        @Test
        @DisplayName("시도 횟수 입력 테스트 실패 : 양의 정수가 아닌 문자 혹은 음의 정수 입력")
        void getTrial_NotPositiveInteger_ExceptionThrown() {
            assertThatThrownBy(() -> InputController.getTrial("abc"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("양의 정수");
            assertThatThrownBy(() -> InputController.getTrial("-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("양의 정수");
        }

        @Test
        @DisplayName("시도 횟수 입력 테스트 성공 : 양의 정수 입력")
        void getTrial_PositiveInteger_Success() {
            assertEquals(InputController.getTrial("30"), 30);
            assertEquals(InputController.getTrial("3"), 3);
        }
    }
}
