package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @Test
    void split_쉼표구분자() {
        String[] names = Parser.split("pobi,crong,honux");
        assertThat(names).containsExactly("pobi", "crong", "honux");
    }

    @Test
    void split_null() {
        assertThatThrownBy(() -> {
            Parser.split(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void split_empty() {
        assertThatThrownBy(() -> {
            Parser.split("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void split_쉼표만() {
        assertThatThrownBy(() -> {
            Parser.split(",,");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void split_다섯글자_초과_이름() {
        assertThatThrownBy(() -> {
            Parser.split("123456,1,2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidRounds_양수_숫자() {
        String input = "5";
        Parser.isValidRounds(input);
        assertThat(5).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "가",""})
    void isValidRounds_isNotDigit(String input) {
        assertThatThrownBy(() -> {
            Parser.isValidRounds(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidRounds_null() {
        assertThatThrownBy(() -> {
            Parser.isValidRounds(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void isValidRounds_isNotPositive(String input) {
        assertThatThrownBy(() -> {
            Parser.isValidRounds(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}