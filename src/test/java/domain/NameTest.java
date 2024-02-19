package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("차 이름의 길이가 1 이상 5이하면 예외를 발생시키지 않는다")
    void validCarName() {
        assertThatCode(() -> Name.from("pobi")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("차 이름의 길이가 1 이상 5이하가 아니면 예외를 발생시킨다")
    void invalidCarName() {
        assertThatIllegalArgumentException().isThrownBy(() -> Name.from("pobibi"));
    }

}
