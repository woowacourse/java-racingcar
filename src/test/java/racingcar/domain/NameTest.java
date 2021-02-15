package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @DisplayName("이름에 공백이 있을 때 에러를 반환 하는지")
    @Test
    void validateBlankInName_NameContainsBlank_throwIllegalArgumentException() {
        assertThatThrownBy(() -> new Name("포비 ")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Name.BLANK_ERROR_MESSAGE);
    }

    @DisplayName("이름이 1자 미만 5자 초과일때 에러를 반환 하는지")
    @ParameterizedTest
    @ValueSource(strings = {"포비넌너무멋져남자가봐도반하겠어", ""})
    void validateNameLength_NameLengthOutOfBounds_throwIllegalArgumentException(String name) {
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Name.NAME_LENGTH_ERROR_MESSAGE);
    }
}