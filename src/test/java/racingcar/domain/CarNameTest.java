package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.domain.CarName.MAX_NAME_LENGTH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    @DisplayName("[Exception] 자동차 이름이 공백이나 null이면 예외를 던진다")
    void createCarByNull(final String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage("자동차 이름에 공백을 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"!!", ",,"})
    @DisplayName("[Exception] 자동차 이름에 한글, 숫자, 영문, '-', '_' 외에 다른 문자가 포함되면 예외를 던진다")
    void createCarByInvalidCharacter(final String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage("올바르지 않은 자동차 이름입니다.");
    }

    @Test
    @DisplayName("[Exception] 자동차 이름의 길이가 5를 초과하면 예외를 던진다")
    void createCarByExcessLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName("ABCDEF"))
                .withMessage(String.format("자동차 이름의 길이가 %d를 초과합니다", MAX_NAME_LENGTH));
    }
}
