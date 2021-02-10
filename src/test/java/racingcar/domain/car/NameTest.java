package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.exception.InvalidNameLengthException;
import racingcar.utils.exception.InvalidTextException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("이름 생성 테스트")
    @Test
    public void create() {
        Name name = new Name("pobi");
        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @DisplayName("이름 길이가 잘못된 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"pobidf", ""})
    public void invalidLengthCreate(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(InvalidNameLengthException.class);
    }

    @DisplayName("문자 외 입력 시 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"pobi#", "jaso!ooon", "장세ㅎ"})
    public void invalidTextCreate(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(InvalidTextException.class);
    }
}