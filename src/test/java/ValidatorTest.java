import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc", "ABCDE", "ABC가나", "가나다", "가나다라마"})
    @DisplayName("이름은 영어, 한글 5자 이내이다")
    void validateCarName(String name) {
        Assertions.assertThatCode(() -> Validator.validateCarName(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a!", "a b", " ", "ABC가나k"})
    @DisplayName("이름은 영어, 한글 5자 이내가 아니면 예외가 발생한다.")
    void invalidateCarName(String name) {
        Assertions.assertThatThrownBy(() -> Validator.validateCarName(name)).isInstanceOf(IllegalArgumentException.class);

    }
}