import org.junit.jupiter.api.Test;
import racingCar.domain.RacingCarNameGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarNameGeneratorTest {
    @Test
    void 자동차_이름을_쉼표로_구분한다() {
        String[] names = RacingCarNameGenerator.generate("pobi,crong,honux");
        assertThat(names[0]).isEqualTo("pobi");
        assertThat(names[1]).isEqualTo("crong");
        assertThat(names[2]).isEqualTo("honux");
    }
}
