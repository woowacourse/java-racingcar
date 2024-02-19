package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차들")
class CarsTest {
    @Test
    @DisplayName("중복된 자동차 이름이 있을 경우 예외가 발생한다.")
    public void verifyNonDuplicateCarNames() {
        //given
        String userInput = "choco,seyan,choco";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> Cars.from(userInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    @DisplayName("사용자 입력이 빈칸이면, 예와가 발생한다.")
    public void verifyBlankUserInput(String userInput) {
        //given&when & then
        assertThrows(IllegalArgumentException.class, () -> Cars.from(userInput));
    }
}