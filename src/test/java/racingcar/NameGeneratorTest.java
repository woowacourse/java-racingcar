package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class NameGeneratorTest {
    @Test
    @DisplayName("쉼표로 자동차 이름 분리 테스트")
    void separateNamesByComma() {
        // given
        String input = "pobi,hoho,richard";

        // when
        NameGenerator nameGenerator = new NameGenerator();
        List<Name> names = nameGenerator.generate(input);

        // then
        assertThat(names).containsExactly(Name.of("pobi"), Name.of("hoho"), Name.of("richard"));
    }

    @ParameterizedTest
    @ValueSource(strings = "hohoho")
    @DisplayName("같은 이름의 자동차가 존재하는지 검증")
        void nameLengthShouldBeLessThenSix(String actual) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Name.of(actual))
            .withMessageMatching("이름은 \\d+글자가 넘을 수 없습니다. :\\d+");
    }

}
