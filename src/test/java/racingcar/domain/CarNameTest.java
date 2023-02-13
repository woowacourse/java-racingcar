package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {

    @Test
    void 생성시_길이가_5를_넘는_데이터가_들어오면_IllegalArgumentException_예외가_발생한다() {
        assertThatThrownBy(() -> new CarName("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이가 초과되었습니다");
    }

    @Test
    void 생성시_null_인_이름이_들어오면_IllegalArgumentException_예외가_발생한다() {
        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 null입니다.");
    }

    @Test
    void 생성시_5이하의_길이가_들어오면_잘_생성됨() {
        assertDoesNotThrow(() -> new CarName("12345"));
    }
}
