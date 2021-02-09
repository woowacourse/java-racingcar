package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    @DisplayName("이름 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"똘이", "똘복이", "똘복순이"})
    void 이름_생성_테스트(String name) {
        Name testName = new Name(name);
        assertThat(testName.toString()).isEqualTo(name);
    }

    @DisplayName("이름 길이 검증 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"똘이는강아지", "똘순이는똘복이", "", "여섯글자이름"})
    void 이름길이_검증_테스트(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(name));
    }
}
