package domain;

import exception.CommaNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {

    @ParameterizedTest
    @DisplayName("쉼표로 구분된 이름이 들어왔을 경우 정상적으로 잘린 이름이 담긴 리스트 반환")
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void validateCorrectNames(String name) {
        //given
        final Names names = new Names("pobi,crong,honux");

        //when
        final List<Name> result = names.getNames();

        //then
        assertThat(result).contains(new Name(name));
    }

    @Test
    @DisplayName("쉼표가 없을 경우 Exception 발생")
    void validateWrongNames() {
        assertThatThrownBy(() -> new Names("pobi"))
                .isInstanceOf(CommaNotFoundException.class);
    }
}
