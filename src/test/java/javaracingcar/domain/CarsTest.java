package javaracingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Nested
    @DisplayName("자동차 이름 입력 테스트")
    class getCarNames {
        @Test
        @DisplayName("자동차 이름 입력 실패 : Null 입력")
        void getCarNames_Null_ExceptionThrown() {
            assertThatThrownBy(() -> new Cars(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
        }

        @Test
        @DisplayName("자동차 이름 입력 실패 : 빈 문자열 입력")
        void getCarNames_NotNull_ExceptionThrown() {
            assertThatThrownBy(() -> new Cars(",,,   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 자동차 이름이 없습니다");
        }


        @Test
        @DisplayName("게임 실행 실패 : 중복된 자동차 이름 전달")
        void init_DuplicatedCarNames_ExceptionThrown() {
            assertThatThrownBy(() -> new Cars("a, b, c, a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름");
        }

        @Test
        @DisplayName("게임 실행 성공 : 중복 없는 자동차 이름 전달")
        void init_NonDuplicatedCarNames_GameSuccessfullyGenerated() {
            Cars cars = new Cars("a, b, c, d");
            List<String> carNames = Arrays.asList("a", "b", "c", "d");
            assertEquals(
                cars.getCars().
                    stream().
                    map(Car::getName).
                    collect(Collectors.toList()),
                carNames);
        }
    }
}