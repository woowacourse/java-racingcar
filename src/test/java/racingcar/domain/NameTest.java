package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    @DisplayName("저장")
    public void saveNameTest() {
        Name name = Name.valueOf("park");

        assertThat(name).isEqualTo(Name.valueOf("park"));
    }

    @ParameterizedTest(name = "양쪽끝 공백을 제거한 자동차 이름이 1자리 미만거나 5자리를 초과하면 RuntimeException이 발생(carName = {arguments})")
    @ValueSource(strings = {"", "abcdef", "  "})
    public void carNameLengthShouldNotBeUnderOneAndOverFive(String name) {
        assertThatThrownBy(() -> {
            Name.valueOf(name);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차 이름이 null이거나 빈문자일 경우에 IllegalArgumentException 발생")
    public void carNameShouldNotBeNullOrEmptyTest() {
        assertThatThrownBy(() -> {
            Name.valueOf(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
