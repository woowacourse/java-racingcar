package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"한대", "자동차#;"})
    void 자동차_입력_수(String input) {
        assertThatThrownBy(() ->
            new Cars(input)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차는 두 대 이상 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"루트,소롱,루트", "루트,루트,루트"})
    void 중복되는_자동차_입력(String input) {
        assertThatThrownBy(() ->
            new Cars(input)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되는 이름을 입력할 수 없습니다.");
    }

    @Test
    void 우승자_찾기() {
        List<String> expected = Arrays.asList("루트", "소롱");
        List<String> actual = new Cars("루트, 소롱").findWinner();
        assertThat(actual).isEqualTo(expected);
    }
}
