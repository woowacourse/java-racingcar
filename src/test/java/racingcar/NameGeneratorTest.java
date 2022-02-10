package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

}
