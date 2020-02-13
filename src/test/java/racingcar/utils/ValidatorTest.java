package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @Test
    void Throw_When_NotValidLengthOfName() {
        String[] names = {"pobiconan", "subway"};

        Assertions.assertThatThrownBy(() ->
            Validator.validateCarNames(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching("5글자 이하로만 입력가능합니다.");
    }

    @Test
    void When_ValidLengthOfName() {
        String[] names = {"crong", "sony"};

        Assertions.assertThatCode(() ->
            Validator.validateCarNames(names))
            .doesNotThrowAnyException();
    }

    @Test
    void Throw_When_DuplicatedName() {
        String[] names = {"pobi", "pobi"};

        Assertions.assertThatThrownBy(() ->
            Validator.validateCarNames(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching("중복된 이름입력이 불가합니다.");
    }

    @Test
    void When_NotDuplicatedName() {
        String[] names = {"pobi", "pob"};

        Assertions.assertThatCode(() ->
            Validator.validateCarNames(names)).doesNotThrowAnyException();
    }

    @Test
    void Throw_when_isValidName() {
        String[] names = {" ", ""};

        Assertions.assertThatThrownBy(() ->
            Validator.validateCarNames(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching("공백만 입력 할 수 없습니다.");
    }

    @Test
    void when_isNotValidName() {
        String[] names = {"  a", " sd "};

        Assertions.assertThatCode(() ->
            Validator.validateCarNames(names)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5"})
    void when_isValidPlayRound(String playRound) {
        Assertions.assertThatCode(() -> Validator.validatePlayRound(playRound)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-3", "-5"})
    void Throw_isNotValidPlayRound(String playRound) {
        Assertions.assertThatThrownBy(() -> Validator.validatePlayRound(playRound))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.1", "-3.1", "5.2"})
    void Throw_isNotIntegerPlayRound(String playRound) {
        Assertions.assertThatThrownBy(() -> Validator.validatePlayRound(playRound))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
