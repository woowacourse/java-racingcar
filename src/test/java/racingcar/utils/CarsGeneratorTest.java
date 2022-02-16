package racingcar.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class CarsGeneratorTest {
    @Test
    void 긴_이름_자동차_에러_검증() {
        assertThatThrownBy(
            () -> CarsGenerator.checkCarNames("pobi,crdong,honux")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ,   , ", ",,,,"})
    void 공백_빈문자열_이름_자동차_에러_검증(String input) {
        assertThatThrownBy(
            () -> CarsGenerator.checkCarNames(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_자동차_생성_검증() {
        assertThat(CarsGenerator.checkCarNames("pobi,crong,honux"))
            .contains("pobi", "crong", "honux");
    }
}