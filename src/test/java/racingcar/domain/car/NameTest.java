package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarNameLengthException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {

    @DisplayName("네임 생성 테스트")
    @Test
    void createName() {
        Name name = new Name("pobi");

        Assertions.assertThat(new Name("pobi")).isEqualTo(name);
    }

    @DisplayName("자동차 이름 길이 검사 - 예외")
    @Test
    void validateCarNameLengthException() {
        assertThatThrownBy(() -> {
            new Name("pobiconan");
        }).isInstanceOf(InvalidCarNameLengthException.class);
    }
}